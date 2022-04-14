package com.finn.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author finn
 * @since 2022-04-13
 */
@Getter
@Setter
@Accessors(chain = true)
@Builder
@TableName("tb_comment")
@ApiModel(value = "Comment对象", description = "")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("评论用户Id")
    private Integer userId;

    @ApiModelProperty("评论文章id")
    private Integer articleId;

    @ApiModelProperty("评论说说id")
    private Integer talkId;

    @ApiModelProperty("评论内容")
    private String commentContent;

    @ApiModelProperty("回复用户id")
    private Integer replyUserId;

    @ApiModelProperty("父评论id")
    private Integer parentId;

    @ApiModelProperty("评论类型 1.文章 2.友链 3.说说")
    private Integer type;

    @ApiModelProperty("是否删除  0否 1是")
    private Integer isDelete;

    @ApiModelProperty("是否审核")
    private Integer isReview;

    @ApiModelProperty("评论时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;


}
