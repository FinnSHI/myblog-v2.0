package com.finn.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.finn.blog.dto.CategoryBackDTO;
import com.finn.blog.dto.CategoryOptionDTO;
import com.finn.blog.entity.Category;
import com.finn.blog.dao.CategoryDao;
import com.finn.blog.entity.Page;
import com.finn.blog.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.finn.blog.utils.BeanCopyUtils;
import com.finn.blog.utils.PageUtils;
import com.finn.blog.vo.ConditionVO;
import com.finn.blog.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author finn
 * @since 2022-04-04
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, Category> implements CategoryService {

    @Autowired
    CategoryDao categoryDao;

    @Override
    public List<CategoryOptionDTO> listCategoriesBySearch(ConditionVO conditionVO) {
        // 搜索分类
        List<Category> categoryList = categoryDao.selectList(new LambdaQueryWrapper<Category>()
                .like(StringUtils.isNotBlank(conditionVO.getKeywords()), Category::getCategoryName, conditionVO.getKeywords())
                .orderByDesc(Category::getId));
        return BeanCopyUtils.copyList(categoryList, CategoryOptionDTO.class);
    }

    @Override
    public PageResult<CategoryBackDTO> listBackCategories(ConditionVO condition) {
        Integer count = categoryDao.selectCount(new LambdaQueryWrapper<Category>()
                .like(StringUtils.isNotBlank(condition.getKeywords()), Category::getCategoryName, condition.getKeywords())
        );
        if(count == 0) {
            return new PageResult<>();
        }
        List<CategoryBackDTO> listCategoriedBack = categoryDao.listCategoryBackDTO(PageUtils.getLimitCurrent(), PageUtils.getSize(), condition);
        return new PageResult<>(listCategoriedBack, count);
    }
}
