package com.finn.blog.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.finn.blog.constant.CommonConst;
import com.finn.blog.dao.UserAuthDao;
import com.finn.blog.dao.UserInfoDao;
import com.finn.blog.dao.UserRoleDao;
import com.finn.blog.dto.EmailDTO;
import com.finn.blog.entity.UserAuth;
import com.finn.blog.entity.UserInfo;
import com.finn.blog.entity.UserRole;
import com.finn.blog.enums.LoginTypeEnum;
import com.finn.blog.enums.RoleEnum;
import com.finn.blog.exception.MyRuntimeException;
import com.finn.blog.service.BlogInfoService;
import com.finn.blog.service.RedisService;
import com.finn.blog.service.UserAuthService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.finn.blog.utils.CommonUtils;
import com.finn.blog.vo.UserVO;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.finn.blog.constant.RabbitMQPrefixConst.*;
import static com.finn.blog.constant.RedisPrefixConst.CODE_EXPIRE_TIME;
import static com.finn.blog.constant.RedisPrefixConst.USER_CODE_KEY;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author finn
 * @since 2022-04-05
 */
@Service
public class UserAuthServiceImpl extends ServiceImpl<UserAuthDao, UserAuth> implements UserAuthService {

    @Autowired
    private RedisService redisService;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private UserAuthDao userAuthDao;
    @Autowired
    private UserInfoDao userInfoDao;
    @Autowired
    private UserRoleDao userRoleDao;
    @Autowired
    private BlogInfoService blogInfoService;

    @Override
    public void sendCode(String username) {
        // 校验账号是否合法
        if (!CommonUtils.checkEmail(username)) {
            throw new MyRuntimeException("请输入正确邮箱");
        }
        // 生成六位随机验证码发送
        String code = CommonUtils.getRandomCode();
        // 发送验证码
        EmailDTO emailDTO = EmailDTO.builder()
                .email(username)
                .subject("验证码")
                .content("您的验证码为 " + code + "。请注意：该验证码有效期为5分钟！")
                .build();
        rabbitTemplate.convertAndSend(EMAIL_EXCHANGE, "*", new Message(JSON.toJSONBytes(emailDTO), new MessageProperties()));
        // 将验证码存入redis，设置过期时间为5分钟
        redisService.set(USER_CODE_KEY + username, code, CODE_EXPIRE_TIME);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void register(UserVO user) {
        // 校验账号是否合法
        if (checkUser(user)) {
            throw new MyRuntimeException("邮箱已被注册！");
        }
        // 新增用户信息
        UserInfo userInfo = UserInfo.builder()
                .email(user.getUsername())
                .nickname(CommonConst.DEFAULT_NICKNAME + IdWorker.getId())
                .avatar(blogInfoService.getWebsiteConfig().getUserAvatar())
                .build();
        userInfoDao.insert(userInfo);
        // 绑定用户角色
        UserRole userRole = UserRole.builder()
                .userId(userInfo.getId())
                .roleId(RoleEnum.USER.getRoleId())
                .build();
        userRoleDao.insert(userRole);
        // 新增用户账号
        UserAuth userAuth = UserAuth.builder()
                .userInfoId(userInfo.getId())
                .username(user.getUsername())
                .password(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()))
                .loginType(LoginTypeEnum.EMAIL.getType())
                .build();
        userAuthDao.insert(userAuth);
    }

    /*
    * @Description: 校验账号是否合法
    * @Param: [user]
    * @return: java.lang.Boolean
    * @Author: Finn
    * @Date: 2022/04/05 22:06
    */
    private Boolean checkUser(UserVO user) {
        if (!user.getCode().equals(redisService.get(USER_CODE_KEY + user.getUsername()))) {
            throw new MyRuntimeException("验证码错误！");
        }
        //查询用户名是否存在
        UserAuth userAuth = userAuthDao.selectOne(new LambdaQueryWrapper<UserAuth>()
                .select(UserAuth::getUsername)
                .eq(UserAuth::getUsername, user.getUsername()));
        return Objects.nonNull(userAuth);
    }

}
