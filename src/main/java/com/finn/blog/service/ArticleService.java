package com.finn.blog.service;


import com.finn.blog.dto.ArticleBackDTO;
import com.finn.blog.entity.Article;
import com.baomidou.mybatisplus.extension.service.IService;
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
}
