package com.finn.blog.dao;

import com.finn.blog.dto.ArticleBackDTO;
import com.finn.blog.entity.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.finn.blog.utils.PageUtils;
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
public interface ArticleDao extends BaseMapper<Article> {
    
    /* 
    * @Description: 查询后台文章总量
    * @Param: [condition] 
    * @return: java.lang.Integer 
    * @Author: Finn
    * @Date: 2022/04/04 20:52
    */
    Integer countArticleBacks(@Param("condition") ConditionVO condition);

    /*
    * @Description: 查询后台文章
    * @Param:
    * @return:
    * @Author: Finn
    * @Date: 2022/04/04 20:55
    */
    List<ArticleBackDTO> listArticleBacks(@Param("current") Long current, @Param("size") Long size, @Param("condition") ConditionVO condition);
}
