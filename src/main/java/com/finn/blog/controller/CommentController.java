package com.finn.blog.controller;


import com.finn.blog.annotation.OptLog;
import com.finn.blog.dto.CommentBackDTO;
import com.finn.blog.dto.CommentDTO;
import com.finn.blog.dto.ReplyDTO;
import com.finn.blog.service.CommentService;
import com.finn.blog.vo.*;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.validation.Valid;
import java.util.List;

import static com.finn.blog.constant.OptTypeConst.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author finn
 * @since 2022-04-13
 */
@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    /*
    * @Description: 查询评论
    * @Param: [commentVO]
    * @return: com.finn.blog.vo.Result<PageResult<CommentDTO>>
    * @Author: Finn
    * @Date: 2022/04/13 11:20
    */
    @ApiOperation(value = "查询评论")
    @GetMapping("/comments")
    public Result<PageResult<CommentDTO>> listComments(CommentVO commentVO) {
        return Result.ok(commentService.listComments(commentVO));
    }

    /*
    * @Description: 添加评论
    * @Param: [commentVO]
    * @return: com.finn.blog.vo.Result<?>
    * @Author: Finn
    * @Date: 2022/04/13 11:32
    */
    @ApiOperation(value = "添加评论")
    @PostMapping("/comments")
    public Result<?> saveComment(@Valid @RequestBody CommentVO commentVO) {
        commentService.saveComment(commentVO);
        return Result.ok();
    }

    /*
    * @Description: 查询评论下的回复
    * @Param: [commentId]
    * @return: com.finn.blog.vo.Result<java.util.List<com.finn.blog.dto.ReplyDTO>>
    * @Author: Finn
    * @Date: 2022/04/13 11:33
    */
    @ApiOperation(value = "查询评论下的回复")
    @ApiImplicitParam(name = "commentId", value = "评论id", required = true, dataType = "Integer")
    @GetMapping("/comments/{commentId}/replies")
    public Result<List<ReplyDTO>> listRepliesByCommentId(@PathVariable("commentId") Integer commentId) {
        return Result.ok(commentService.listRepliesByCommentId(commentId));
    }

    /*
    * @Description: 评论点赞
    * @Param: [commentId]
    * @return: com.finn.blog.vo.Result<?>
    * @Author: Finn
    * @Date: 2022/04/13 11:33
    */
    @ApiOperation(value = "评论点赞")
    @PostMapping("/comments/{commentId}/like")
    public Result<?> saveCommentLike(@PathVariable("commentId") Integer commentId) {
        commentService.saveCommentLike(commentId);
        return Result.ok();
    }

    /*
    * @Description: 审核评论
    * @Param: [reviewVO]
    * @return: com.finn.blog.vo.Result<?>
    * @Author: Finn
    * @Date: 2022/04/13 11:33
    */
    @OptLog(optType = UPDATE)
    @ApiOperation(value = "审核评论")
    @PutMapping("/admin/comments/review")
    public Result<?> updateCommentsReview(@Valid @RequestBody ReviewVO reviewVO) {
        commentService.updateCommentsReview(reviewVO);
        return Result.ok();
    }

    /*
    * @Description: 删除评论
    * @Param: [commentIdList]
    * @return: com.finn.blog.vo.Result<?>
    * @Author: Finn
    * @Date: 2022/04/13 11:33
    */
    @OptLog(optType = REMOVE)
    @ApiOperation(value = "删除评论")
    @DeleteMapping("/admin/comments")
    public Result<?> deleteComments(@RequestBody List<Integer> commentIdList) {
        commentService.removeByIds(commentIdList);
        return Result.ok();
    }

    /*
    * @Description: 查询后台评论
    * @Param: [condition]
    * @return: com.finn.blog.vo.Result<com.finn.blog.vo.PageResult<CommentBackDTO>>
    * @Author: Finn
    * @Date: 2022/04/13 11:33
    */
    @ApiOperation(value = "查询后台评论")
    @GetMapping("/admin/comments")
    public Result<PageResult<CommentBackDTO>> listCommentBackDTO(ConditionVO condition) {
        return Result.ok(commentService.listCommentBackDTO(condition));
    }


}
