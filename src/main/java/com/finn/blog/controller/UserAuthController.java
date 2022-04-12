package com.finn.blog.controller;


import com.finn.blog.dao.UserAuthDao;
import com.finn.blog.dto.UserAreaDTO;
import com.finn.blog.service.UserAuthService;
import com.finn.blog.vo.ConditionVO;
import com.finn.blog.vo.Result;
import com.finn.blog.vo.UserVO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author finn
 * @since 2022-04-05
 */
@RestController
public class UserAuthController {

    @Autowired
    private UserAuthService userAuthService;

    /*
    * @Description: 发送邮箱验证码
    * @Param: [username]
    * @return: com.finn.blog.vo.Result<?>
    * @Author: Finn
    * @Date: 2022/04/05 21:49
    */
    @ApiOperation(value = "发送邮箱验证码")
    @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String")
    @GetMapping("/users/code")
    public Result<?> sendCode(String username) {
        userAuthService.sendCode(username);
        return Result.ok();
    }

    /*
    * @Description: 用户注册
    * @Param: [user]
    * @return: com.finn.blog.vo.Result<?>
    * @Author: Finn
    * @Date: 2022/04/05 21:43
    */
    @ApiOperation(value = "用户注册")
    @PostMapping("/register")
        public Result<?> register(@Valid @RequestBody UserVO user) {
        userAuthService.register(user);
        return Result.ok();
    }

    /*
    * @Description: 获取用户区域分布
    * @Param: [conditionVO]
    * @return: com.finn.blog.vo.Result<java.util.List<UserAreaDTO>>
    * @Author: Finn
    * @Date: 2022/04/12 13:59
    */
    @ApiOperation(value = "获取用户区域分布")
    @GetMapping("/admin/users/area")
    public Result<List<UserAreaDTO>> listUserAreas(ConditionVO conditionVO) {
        return Result.ok(userAuthService.listUserAreas(conditionVO));
    }
}
