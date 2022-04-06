package com.finn.blog.service;

import com.finn.blog.entity.UserAuth;
import com.baomidou.mybatisplus.extension.service.IService;
import com.finn.blog.vo.UserVO;

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
}
