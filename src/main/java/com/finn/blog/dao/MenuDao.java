package com.finn.blog.dao;

import com.finn.blog.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author finn
 * @since 2022-04-04
 */
@Repository
public interface MenuDao extends BaseMapper<Menu> {

}
