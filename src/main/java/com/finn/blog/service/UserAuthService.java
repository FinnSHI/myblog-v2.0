package com.finn.blog.service;

import com.finn.blog.dto.UserAreaDTO;
import com.finn.blog.entity.UserAuth;
import com.baomidou.mybatisplus.extension.service.IService;
import com.finn.blog.vo.ConditionVO;
import com.finn.blog.vo.UserVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author finn
 * @since 2022-04-05
 */
public interface UserAuthService extends IService<UserAuth> {

    /* 
    * @Description: 发送邮箱验证码 
    * @Param: [username] 
    * @return: void 
    * @Author: Finn
    * @Date: 2022/04/05 21:49
    */
    void sendCode(String username);

    /* 
    * @Description: 注册 
    * @Param: [user] 
    * @return: void 
    * @Author: Finn
    * @Date: 2022/04/05 21:50
    */
    void register(UserVO user);

    /*
    * @Description: 获取用户地域分布
    * @Param: [conditionVO]
    * @return: java.util.List<com.finn.blog.dto.UserAreaDTO>
    * @Author: Finn
    * @Date: 2022/04/12 14:00
    */
    List<UserAreaDTO> listUserAreas(ConditionVO conditionVO);
}
