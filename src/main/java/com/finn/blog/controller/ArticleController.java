package com.finn.blog.controller;


import com.finn.blog.dto.ArticleBackDTO;
import com.finn.blog.service.ArticleService;
import com.finn.blog.vo.ConditionVO;
import com.finn.blog.vo.PageResult;
import com.finn.blog.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  文章控制器
 * </p>
 *
 * @author finn
 * @since 2022-04-04
 */
@Api("文章controller")
@RestController
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @ApiOperation(value = "获取后台文章列表")
    @GetMapping(value = "/admin/articles")
    public Result<PageResult<ArticleBackDTO>> listArticleBacks(ConditionVO conditionVO) {
        return Result.ok(articleService.listArticleBacks(conditionVO));
    }
}
