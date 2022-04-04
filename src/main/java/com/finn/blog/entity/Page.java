package com.finn.blog.entity;

/*
 * @description:
 * @author: Finn
 * @create: 2022/04/04 01:13
 */
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

/*
 * @description: 页面
 * @author: Finn
 * @create: 2022/04/04 00:56
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("tb_page")
@ApiModel(value = "Page对象", description = "页面")
public class Page implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("页面id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("页面标签")
    private String pageName;

    @ApiModelProperty("页面名")
    private String pageDescription;

    @ApiModelProperty("页面封面")
    private String pageCover;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;


}

