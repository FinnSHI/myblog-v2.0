package com.finn.blog.dao;

import com.finn.blog.dto.*;
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

    /*
    * @Description: 查询首页文章
    * @Param: [current, size]
    * @return: java.util.List<com.finn.blog.dto.ArticleHomeDTO>
    * @Author: Finn
    * @Date: 2022/04/05 20:51
    */
    List<ArticleHomeDTO> listArticles(@Param("current") Long current, @Param("size") Long size);

    /* 
    * @Description: 查看推荐文章 
    * @Param: [articleId] 
    * @return: java.util.List<com.finn.blog.dto.ArticleRecommendDTO> 
    * @Author: Finn
    * @Date: 2022/04/05 21:28
    */
    List<ArticleRecommendDTO> listRecommendArticles(@Param("articleId") Integer articleId);

    /*
    * @Description: 根据id查询文章
    * @Param: [articleId]
    * @return: com.finn.blog.dto.ArticleDTO
    * @Author: Finn
    * @Date: 2022/04/05 21:33
    */
    ArticleDTO getArticleById(@Param("articleId") Integer articleId);

    /* 
    * @Description: 文章统计 
    * @Param: [] 
    * @return: java.util.List<com.finn.blog.dto.ArticleStatisticsDTO> 
    * @Author: Finn
    * @Date: 2022/04/12 13:41
    */
    List<ArticleStatisticsDTO> listArticleStatistics();
}
