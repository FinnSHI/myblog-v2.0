package com.finn.blog.controller;

import com.finn.blog.annotation.OptLog;
import com.finn.blog.dto.BlogBackInfoDTO;
import com.finn.blog.dto.BlogHomeInfoDTO;
import com.finn.blog.service.BlogInfoService;
import com.finn.blog.vo.BlogInfoVO;
import com.finn.blog.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.finn.blog.constant.OptTypeConst.UPDATE;

/*
 * @description: 博客信息控制层
 * @author: Finn
 * @create: 2022/04/04 17:01
 */
@Api(tags = "博客信息模块")
@RestController
public class BlogInfoController {

    @Autowired
    private BlogInfoService blogInfoService;

    /*
    * @Description: 博客配置信息
    * @Param: []
    * @return: com.finn.blog.vo.Result<BlogHomeInfoDTO>
    * @Author: Finn
    * @Date: 2022/04/05 19:13
    */
    @ApiOperation(value = "博客配置信息")
    @GetMapping("/")
    public Result<BlogHomeInfoDTO> getBlogHomeInfo() {
        return Result.ok(blogInfoService.getBlogHomeInfo());
    }

    /*
    * @Description: 上传访客信息
    * @Param: []
    * @return: com.finn.blog.vo.Result<?>
    * @Author: Finn
    * @Date: 2022/04/04 17:01
    */
    @ApiOperation(value = "上传访客信息")
    @PostMapping("/report")
    public Result<?> report() {
        blogInfoService.report();
        return Result.ok();
    }

    /* 
    * @Description: 查看关于我 
    * @Param: [] 
    * @return: com.finn.blog.vo.Result<java.lang.String> 
    * @Author: Finn
    * @Date: 2022/04/08 21:54
    */
    @ApiOperation(value = "查看关于我信息")
    @GetMapping("/about")
    public Result<String> getAbout() {
        return Result.ok(blogInfoService.getAbout());
    }

    /**
     * 修改关于我信息
     *
     * @param blogInfoVO 博客信息
     * @return {@link Result<>}
     */
    @OptLog(optType = UPDATE)
    @ApiOperation(value = "修改关于我信息")
    @PutMapping("/admin/about")
    public Result<?> updateAbout(@Valid @RequestBody BlogInfoVO blogInfoVO) {
        blogInfoService.updateAbout(blogInfoVO);
        return Result.ok();
    }

    /*
    * @Description: 查看后台信息
    * @Param: []
    * @return: com.finn.blog.vo.Result<BlogBackInfoDTO>
    * @Author: Finn
    * @Date: 2022/04/04 20:27
    */
    @ApiOperation(value = "查看后台信息")
    @GetMapping("/admin")
    public Result<BlogBackInfoDTO> getBlogBackInfo() {
        return Result.ok(blogInfoService.getBlogBackInfo());
    }


}
