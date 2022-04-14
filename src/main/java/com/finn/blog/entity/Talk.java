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
 * @since 2022-04-13
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("tb_talk")
@ApiModel(value = "Talk对象", description = "")
public class Talk implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("说说id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("用户id")
    private Integer userId;

    @ApiModelProperty("说说内容")
    private String content;

    @ApiModelProperty("图片")
    private String images;

    @ApiModelProperty("是否置顶")
    private Boolean isTop;

    @ApiModelProperty("状态 1.公开 2.私密")
    private Boolean status;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;


}
