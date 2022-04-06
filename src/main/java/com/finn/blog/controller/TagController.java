package com.finn.blog.controller;


import com.finn.blog.dto.TagBackDTO;
import com.finn.blog.dto.TagDTO;
import com.finn.blog.service.TagService;
import com.finn.blog.vo.ConditionVO;
import com.finn.blog.vo.PageResult;
import com.finn.blog.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author finn
 * @since 2022-04-04
 */
@RestController
public class TagController {

    @Autowired
    TagService tagService;

    /*
    * @Description: 文章列表搜索标签
    * @Param: [condition]
    * @return: com.finn.blog.vo.Result<java.util.List<com.finn.blog.dto.TagDTO>>
    * @Author: Finn
    * @Date: 2022/04/05 00:20
    */
    @ApiOperation(value = "文章列表搜索标签")
    @GetMapping("/admin/tags/search")
    public Result<List<TagDTO>> listTagsBySearch(ConditionVO condition) {
        return Result.ok(tagService.listTagsBySearch(condition));
    }

    /*
    * @Description: 查询后台标签列表
    * @Param: [condition]
    * @return: com.finn.blog.vo.Result<PageResult<TagBackDTO>>
    * @Author: Finn
    * @Date: 2022/04/05 10:13
    */
    @ApiOperation(value = "查询后台标签列表")
    @GetMapping("/admin/tags")
    public Result<PageResult<TagBackDTO>> listTagBackDTO(ConditionVO condition) {
        return Result.ok(tagService.listTagBackDTO(condition));
    }
}
