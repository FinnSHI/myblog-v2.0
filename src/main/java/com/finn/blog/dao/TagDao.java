package com.finn.blog.dao;

import com.finn.blog.dto.TagBackDTO;
import com.finn.blog.entity.Tag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.finn.blog.vo.ConditionVO;
import org.apache.ibatis.annotations.Param;
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
public interface TagDao extends BaseMapper<Tag> {

    /*
    * @Description: 根据文章id查询标签名
    * @Param: [articleId]
    * @return: java.util.List<java.lang.String>
    * @Author: Finn
    * @Date: 2022/04/05 00:04
    */
    List<String> listTagNameByArticleId(Integer articleId);

    /*
    * @Description: 后台标签列表
    * @Param: [current, size, condition]
    * @return: java.util.List<com.finn.blog.dto.TagBackDTO>
    * @Author: Finn
    * @Date: 2022/04/05 10:15
    */
    List<TagBackDTO> listTagBackDTO(@Param("current") Long current, @Param("size") Long size, @Param("condition") ConditionVO condition);
}
