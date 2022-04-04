package com.finn.blog.handler;

import com.alibaba.fastjson.JSON;
import com.finn.blog.vo.Result;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.finn.blog.constant.CommonConst.APPLICATION_JSON;

/*
 * @description: 用户未登录处理
 * @author: Finn
 * @create: 2022/04/04 00:24
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException {
        httpServletResponse.setContentType(APPLICATION_JSON);
        httpServletResponse.getWriter().write(JSON.toJSONString(Result.fail("用户未登录")));
    }

}
