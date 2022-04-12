package com.finn.blog.controller;


import com.finn.blog.dto.CategoryBackDTO;
import com.finn.blog.dto.CategoryDTO;
import com.finn.blog.dto.CategoryOptionDTO;
import com.finn.blog.service.CategoryService;
import com.finn.blog.vo.ConditionVO;
import com.finn.blog.vo.PageResult;
import com.finn.blog.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author finn
 * @since 2022-04-04
 */
@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    /*
    * @Description: 文章列表搜索分类
    * @Param: [condition]
    * @return: Result<List<CategoryOptionDTO>>
    * @Author: Finn
    * @Date: 2022/04/05 00:08
    */
    @ApiOperation(value = "文章列表搜索分类")
    @GetMapping("/admin/categories/search")
    public Result<List<CategoryOptionDTO>> listCategoriesBySearch(ConditionVO condition) {
        return Result.ok(categoryService.listCategoriesBySearch(condition));
    }

    /*
    * @Description: 后台分类列表
    * @Param: [condition]
    * @return: com.finn.blog.vo.Result<PageResult<CategoryBackDTO>>
    * @Author: Finn
    * @Date: 2022/04/05 09:57
    */
    @ApiOperation(value = "后台分类列表")
    @GetMapping("/admin/categories")
    public Result<PageResult<CategoryBackDTO>> listBackCategories(ConditionVO condition) {
        return Result.ok(categoryService.listBackCategories(condition));
    }

    /*
    * @Description: 博客展示页查看分类
    * @Param: []
    * @return: com.finn.blog.vo.Result<com.finn.blog.vo.PageResult<CategoryDTO>>
    * @Author: Finn
    * @Date: 2022/04/08 20:29
    */
    @ApiOperation(value = "查看分类列表")
    @GetMapping("/categories")
    public Result<PageResult<CategoryDTO>> listCategories() {
        return Result.ok(categoryService.listCategories());
    }
}
