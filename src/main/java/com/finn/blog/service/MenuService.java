package com.finn.blog.service;

import com.finn.blog.dto.UserMenuDTO;

import java.util.List;

/*
 * @description:
 * @author: Finn
 * @create: 2022/04/04 16:11
 */
public interface MenuService {

    List<UserMenuDTO>  listUserMenus();
}
