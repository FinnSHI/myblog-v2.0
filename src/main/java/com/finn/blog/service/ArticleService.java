package com.finn.blog.service;


import com.finn.blog.dto.ArchiveDTO;
import com.finn.blog.dto.ArticleBackDTO;
import com.finn.blog.dto.ArticleDTO;
import com.finn.blog.dto.ArticleHomeDTO;
import com.finn.blog.entity.Article;
import com.baomidou.mybatisplus.extension.service.IService;
import com.finn.blog.vo.ArticleTopVO;
import com.finn.blog.vo.ArticleVO;
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
public interface ArticleService extends IService<Article> {

    /*
    * @Description: 获取后台文章列表
    * @Param: [conditionVO]
    * @return: cn.hutool.db.PageResult<com.finn.blog.dto.ArticleBackDTO>
    * @Author: Finn
    * @Date: 2022/04/04 20:50
    */
    PageResult<ArticleBackDTO> listArticleBacks(ConditionVO conditionVO);

    /* 
    * @Description: 置顶文章 
    * @Param: [articleTopVO] 
    * @return: void 
    * @Author: Finn
    * @Date: 2022/04/04 21:22
    */
    void updateArticleTop(ArticleTopVO articleTopVO);

    /*
    * @Description: 根据id查看后台文章
    * @Param: [articleId]
    * @return: com.finn.blog.vo.ArticleVO
    * @Author: Finn
    * @Date: 2022/04/05 00:03
    */
    ArticleVO getArticleBackById(Integer articleId);

    /* 
    * @Description: 添加或删除文章 
    * @Param: [articleVO] 
    * @return: void 
    * @Author: Finn
    * @Date: 2022/04/04 21:31
    */
    void saveOrUpdateArticle(ArticleVO articleVO);

    /*
    * @Description: 查看博客首页文章
    * @Param: []
    * @return: java.util.List<com.finn.blog.dto.ArticleHomeDTO>
    * @Author: Finn
    * @Date: 2022/04/05 20:49
    */
    List<ArticleHomeDTO> listArticles();

    /*
    * @Description: 查看博客文章详情
    * @Param: [articleId]
    * @return: com.finn.blog.dto.ArticleDTO
    * @Author: Finn
    * @Date: 2022/04/05 21:16
    */
    ArticleDTO getArticleById(Integer articleId);

    /*
    * @Description: 查看文章归档
    * @Param: []
    * @return: com.finn.blog.vo.PageResult<com.finn.blog.dto.ArchiveDTO>
    * @Author: Finn
    * @Date: 2022/04/08 19:53
    */
    PageResult<ArchiveDTO> listArchives();

    /* 
    * @Description: 点赞文章 
    * @Param: [articleId] 
    * @return: void 
    * @Author: Finn
    * @Date: 2022/04/12 17:08
    */
    void saveArticleLike(Integer articleId);
}
