package com.finn.blog.service;

import com.finn.blog.dto.CategoryBackDTO;
import com.finn.blog.dto.CategoryDTO;
import com.finn.blog.dto.CategoryOptionDTO;
import com.finn.blog.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import com.finn.blog.vo.ConditionVO;
import com.finn.blog.vo.PageResult;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author finn
 * @since 2022-04-04
 */
public interface CategoryService extends IService<Category> {
    
    /* 
    * @Description: 获取文章的分类
    * @Param: [conditionVO] 
    * @return: java.util.List<CategoryOptionDTO> 
    * @Author: Finn
    * @Date: 2022/04/05 00:09
    */
    List<CategoryOptionDTO> listCategoriesBySearch(ConditionVO conditionVO);

    /*
    * @Description: 列出后台分类列表
    * @Param: [condition]
    * @return: com.finn.blog.vo.PageResult<com.finn.blog.dto.CategoryBackDTO>
    * @Author: Finn
    * @Date: 2022/04/05 09:58
    */
    PageResult<CategoryBackDTO> listBackCategories(ConditionVO condition);

    /*
    * @Description: 博客分类
    * @Param: []
    * @return: com.finn.blog.vo.PageResult<com.finn.blog.dto.CategoryDTO>
    * @Author: Finn
    * @Date: 2022/04/08 20:31
    */
    PageResult<CategoryDTO> listCategories();
}
