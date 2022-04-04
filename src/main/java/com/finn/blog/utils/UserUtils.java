package com.finn.blog.utils;

import com.finn.blog.dto.UserDetailDTO;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/*
 * @description: user工具类
 * @author: Finn
 * @create: 2022/04/04 00:34
 */
@Component
public class UserUtils {

    /**
     * 获取当前登录用户
     *
     * @return 用户登录信息
     */
    public static UserDetailDTO getLoginUser() {
        return (UserDetailDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
