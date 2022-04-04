package com.finn.blog.service;


import com.finn.blog.dto.ArticleBackDTO;
import com.finn.blog.entity.Article;
import com.baomidou.mybatisplus.extension.service.IService;
import com.finn.blog.vo.ArticleTopVO;
import com.finn.blog.vo.ArticleVO;
import com.finn.blog.vo.ConditionVO;
import com.finn.blog.vo.PageResult;

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
    * @Description: 添加或删除文章 
    * @Param: [articleVO] 
    * @return: void 
    * @Author: Finn
    * @Date: 2022/04/04 21:31
    */
    void saveOrUpdateArticle(ArticleVO articleVO);
}
