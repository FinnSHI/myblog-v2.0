package com.finn.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author finn
 * @since 2022-04-04
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("tb_article")
@ApiModel(value = "Article对象", description = "")
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("作者")
    private Integer userId;

    @ApiModelProperty("文章分类")
    private Integer categoryId;

    @ApiModelProperty("文章缩略图")
    private String articleCover;

    @ApiModelProperty("标题")
    private String articleTitle;

    @ApiModelProperty("内容")
    private String articleContent;

    @ApiModelProperty("文章类型 1原创 2转载 3翻译")
    private Boolean type;

    @ApiModelProperty("原文链接")
    private String originalUrl;

    @ApiModelProperty("是否置顶 0否 1是")
    private Boolean isTop;

    @ApiModelProperty("是否删除  0否 1是")
    private Boolean isDelete;

    @ApiModelProperty("状态值 1公开 2私密 3评论可见")
    private Boolean status;

    @ApiModelProperty("发表时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;


}
