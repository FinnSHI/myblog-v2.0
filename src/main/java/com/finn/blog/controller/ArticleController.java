package com.finn.blog.controller;


import com.finn.blog.annotation.OptLog;
import com.finn.blog.dto.ArticleBackDTO;
import com.finn.blog.service.ArticleService;
import com.finn.blog.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.finn.blog.constant.OptTypeConst.*;

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

    /*
    * @Description: 获取后台文章列表
    * @Param: [conditionVO]
    * @return: com.finn.blog.vo.Result<com.finn.blog.vo.PageResult<com.finn.blog.dto.ArticleBackDTO>>
    * @Author: Finn
    * @Date: 2022/04/04 21:14
    */
    @ApiOperation(value = "获取后台文章列表")
    @GetMapping(value = "/admin/articles")
    public Result<PageResult<ArticleBackDTO>> listArticleBacks(ConditionVO conditionVO) {
        return Result.ok(articleService.listArticleBacks(conditionVO));
    }

    /*
    * @Description: 获取
    * @Param:
    * @return:
    * @Author: Finn
    * @Date: 2022/04/04 21:14
    */
    @OptLog(optType = UPDATE)
    @ApiOperation(value = "修改文章置顶")
    @PutMapping("/admin/articles/top")
    public Result<?> updateArticleTop(@Valid @RequestBody ArticleTopVO articleTopVO) {
        articleService.updateArticleTop(articleTopVO);
        return Result.ok();
    }

    /*
    * @Description: 添加或修改文章
    * @Param: [articleVO]
    * @return: com.finn.blog.vo.Result<?>
    * @Author: Finn
    * @Date: 2022/04/04 21:27
    */
    @OptLog(optType = SAVE_OR_UPDATE)
    @ApiOperation(value = "添加或修改文章")
    @PostMapping("/admin/articles")
    public Result<?> saveOrUpdateArticle(@Valid @RequestBody ArticleVO articleVO) {
        articleService.saveOrUpdateArticle(articleVO);
        return Result.ok();
    }
}
