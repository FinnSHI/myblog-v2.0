package com.finn.blog.controller;

import com.finn.blog.dto.BlogBackInfoDTO;
import com.finn.blog.service.BlogInfoService;
import com.finn.blog.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
    * @Description: 上传博客信息
    * @Param: []
    * @return: com.finn.blog.vo.Result<?>
    * @Author: Finn
    * @Date: 2022/04/04 17:01
    */
    @ApiOperation(value = "上传博客信息")
    @PostMapping("/report")
    public Result<?> report() {
        blogInfoService.report();
        return Result.ok();
    }

//    /*
//    * @Description: 查看后台信息
//    * @Param: []
//    * @return: com.finn.blog.vo.Result<BlogBackInfoDTO>
//    * @Author: Finn
//    * @Date: 2022/04/04 20:27
//    */
//    @ApiOperation(value = "查看后台信息")
//    @GetMapping("/admin")
//    public Result<BlogBackInfoDTO> getBlogBackInfo() {
//        return Result.ok(blogInfoService.getBlogBackInfo());
//    }


}
