package com.finn.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.finn.blog.entity.Page;
import com.finn.blog.vo.PageVO;

import java.util.List;

/*
 * @description: 页面服务层
 * @author: Finn
 * @create: 2022/04/05 19:24
 */
public interface PageService extends IService<Page> {

    /*
    * @Description: 查询页面图片
    * @Param: []
    * @return: java.util.List<com.finn.blog.vo.PageVO>
    * @Author: Finn
    * @Date: 2022/04/05 19:27
    */
    List<PageVO> listPages();
}
