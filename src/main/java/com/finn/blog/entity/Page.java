package com.finn.blog.entity;

/*
 * @description:
 * @author: Finn
 * @create: 2022/04/04 01:13
 */
import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/*
 * @description: 页面
 * @author: Finn
 * @create: 2022/04/04 00:56
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName("tb_page")
@ApiModel(value = "页面信息", description = "页面")
public class Page implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 页面id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 页面名
     */
    private String pageName;

    /**
     * 页面标签
     */
    private String pageLabel;

    /**
     * 页面封面
     */
    private String pageCover;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;


}

