package com.finn.blog.controller;

import com.finn.blog.service.BlogInfoService;
import com.finn.blog.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @description: 博客信息控制层
 * @author: Finn
 * @create: 2022/04/04 17:01
 */
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
    @PostMapping("/report")
    public Result<?> report() {
        blogInfoService.report();
        return Result.ok();
    }
}
