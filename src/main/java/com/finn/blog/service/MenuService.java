package com.finn.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.finn.blog.dto.MenuDTO;
import com.finn.blog.dto.UserMenuDTO;
import com.finn.blog.entity.Menu;
import com.finn.blog.vo.ConditionVO;

import java.util.List;

/*
 * @description:
 * @author: Finn
 * @create: 2022/04/04 16:11
 */
public interface MenuService extends IService<Menu> {

    /*
    * @Description: 获取菜单列表 
    * @Param: [conditionVO] 
    * @return: java.util.List<com.finn.blog.dto.MenuDTO> 
    * @Author: Finn
    * @Date: 2022/04/04 17:07
    */
    List<MenuDTO>  getMenuList(ConditionVO conditionVO);
}
