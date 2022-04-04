package com.finn.blog.controller;

import com.finn.blog.dto.UserMenuDTO;
import com.finn.blog.service.MenuService;
import com.finn.blog.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
 * @description: 菜单
 * @author: Finn
 * @create: 2022/04/04 16:08
 */
@Api(tags = "菜单模块")
@RestController
public class MenuController {

    @Autowired
    MenuService menuService;

    /*
    * @Description: 查看当前用户菜单
    * @Param: []
    * @return: com.finn.blog.vo.Result<java.util.List<UserMenuDTO>>
    * @Author: Finn
    * @Date: 2022/04/04 16:09
    */
    @ApiOperation(value = "查看当前用户菜单")
    @GetMapping("/admin/user/menus")
    public Result<List<UserMenuDTO>> listUserMenus() {
        return Result.ok(menuService.listUserMenus());
    }
}
