package com.finn.blog.dao;

import com.finn.blog.dto.UniqueViewDTO;
import com.finn.blog.entity.UniqueView;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author finn
 * @since 2022-04-12
 */
@Repository
public interface UniqueViewDao extends BaseMapper<UniqueView> {

    /* 
    * @Description: 获取7天用户量 
    * @Param: [startTime, endTime] 
    * @return: java.util.List<com.finn.blog.dto.UniqueViewDTO> 
    * @Author: Finn
    * @Date: 2022/04/12 13:35
    */
    List<UniqueViewDTO> listUniqueViews(@Param("startTime") Date startTime, @Param("endTime") Date endTime);
}
