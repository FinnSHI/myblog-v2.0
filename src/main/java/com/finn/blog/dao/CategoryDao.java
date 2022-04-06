package com.finn.blog.dao;
import com.finn.blog.dto.CategoryBackDTO;
import com.finn.blog.entity.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.finn.blog.vo.ConditionVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author finn
 * @since 2022-04-04
 */
@Repository
public interface CategoryDao extends BaseMapper<Category> {

    /*
    * @Description: 列出后台分类
    * @Param: [current, size, condition]
    * @return: java.util.List<com.finn.blog.dto.CategoryBackDTO>
    * @Author: Finn
    * @Date: 2022/04/05 10:06
    */
    List<CategoryBackDTO> listCategoryBackDTO(@Param("current") Long current, @Param("size") Long size, @Param("condition") ConditionVO condition);
}
