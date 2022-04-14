package com.finn.blog.dao;

import com.finn.blog.entity.Message;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author finn
 * @since 2022-04-13
 */
@Repository
public interface MessageMapper extends BaseMapper<Message> {

}
