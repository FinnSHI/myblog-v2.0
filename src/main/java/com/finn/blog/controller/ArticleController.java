package com.finn.blog.controller;


import com.finn.blog.annotation.OptLog;
import com.finn.blog.dto.ArchiveDTO;
import com.finn.blog.dto.ArticleBackDTO;
import com.finn.blog.dto.ArticleDTO;
import com.finn.blog.dto.ArticleHomeDTO;
import com.finn.blog.enums.FilePathEnum;
import com.finn.blog.service.ArticleService;
import com.finn.blog.strategy.context.UploadStrategyContext;
import com.finn.blog.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

import java.util.List;

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
    private ArticleService articleService;

    @Autowired
    private UploadStrategyContext uploadStrategyContext;

    /* 
    * @Description: 查看首页文章 
    * @Param: [] 
    * @return: com.finn.blog.vo.Result<java.util.List<ArticleHomeDTO>> 
    * @Author: Finn
    * @Date: 2022/04/05 20:46
    */
    @ApiOperation(value = "查看首页文章")
    @GetMapping("/articles")
    public Result<List<ArticleHomeDTO>> listArticles() {
        return Result.ok(articleService.listArticles());
    }

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
    * @Description: 查看文章
    * @Param: [articleId]
    * @return: com.finn.blog.vo.Result<ArticleDTO>
    * @Author: Finn
    * @Date: 2022/04/05 21:11
    */
    @ApiOperation(value = "根据id查看文章")
    @ApiImplicitParam(name = "articleId", value = "文章id", required = true, dataType = "Integer")
    @GetMapping("/articles/{articleId}")
    public Result<ArticleDTO> getArticleById(@PathVariable("articleId") Integer articleId) {
        return Result.ok(articleService.getArticleById(articleId));
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
    * @Description: 根据id查看后台文章
    * @Param: [articleId]
    * @return: com.finn.blog.vo.Result<com.finn.blog.vo.ArticleVO>
    * @Author: Finn
    * @Date: 2022/04/05 00:03
    */
    @ApiOperation(value = "根据id查看后台文章")
    @ApiImplicitParam(name = "articleId", value = "文章id", required = true, dataType = "Integer")
    @GetMapping("/admin/articles/{articleId}")
    public Result<ArticleVO> getArticleBackById(@PathVariable("articleId") Integer articleId) {
        return Result.ok(articleService.getArticleBackById(articleId));
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

    /* 
    * @Description: 上传文章图片 
    * @Param: [file] 
    * @return: com.finn.blog.vo.Result<java.lang.String> 
    * @Author: Finn
    * @Date: 2022/04/05 17:45
    */
    @ApiOperation(value = "上传文章图片")
    @ApiImplicitParam(name = "file", value = "文章图片", required = true, dataType = "MultipartFile")
    @PostMapping("/admin/articles/images")
    public Result<String> saveArticleImages(MultipartFile file) {
        return Result.ok(uploadStrategyContext.executeUploadStrategy(file, FilePathEnum.ARTICLE.getPath()));
    }

    /*
    * @Description: 查看文章归档
    * @Param: []
    * @return: com.finn.blog.vo.Result<com.finn.blog.vo.PageResult<ArchiveDTO>>
    * @Author: Finn
    * @Date: 2022/04/08 19:47
    */
    @ApiOperation(value = "查看文章归档")
    @GetMapping("/articles/archives")
    public Result<PageResult<ArchiveDTO>> listArchives() {
        return Result.ok(articleService.listArchives());
    }
}
