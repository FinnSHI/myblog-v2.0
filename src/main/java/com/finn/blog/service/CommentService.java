package com.finn.blog.service;

import com.finn.blog.dto.CommentBackDTO;
import com.finn.blog.dto.CommentDTO;
import com.finn.blog.dto.ReplyDTO;
import com.finn.blog.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.finn.blog.vo.CommentVO;
import com.finn.blog.vo.ConditionVO;
import com.finn.blog.vo.PageResult;
import com.finn.blog.vo.ReviewVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author finn
 * @since 2022-04-13
 */
public interface CommentService extends IService<Comment> {

    /*
    * @Description: 查看评论
    * @Param: [commentVO]
    * @return: PageResult<CommentDTO>
    * @Author: Finn
    * @Date: 2022/04/13 11:40
    */
    PageResult<CommentDTO> listComments(CommentVO commentVO);

    /**
     * 查看评论下的回复
     *
     * @param commentId 评论id
     * @return 回复列表
     */
    List<ReplyDTO> listRepliesByCommentId(Integer commentId);

    /**
     * 添加评论
     *
     * @param commentVO 评论对象
     */
    void saveComment(CommentVO commentVO);

    /**
     * 点赞评论
     *
     * @param commentId 评论id
     */
    void saveCommentLike(Integer commentId);

    /**
     * 审核评论
     *
     * @param reviewVO 审核信息
     */
    void updateCommentsReview(ReviewVO reviewVO);

    /**
     * 查询后台评论
     *
     * @param condition 条件
     * @return 评论列表
     */
    PageResult<CommentBackDTO> listCommentBackDTO(ConditionVO condition);
}
