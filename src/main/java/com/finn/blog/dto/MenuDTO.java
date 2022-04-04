package com.finn.blog.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/*
 * @description: Menu
 * @author: Finn
 * @create: 2022/04/04 16:33
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
@ApiModel(value = "MenuDTO", description = "菜单目录")
public class MenuDTO {

    @ApiModelProperty(value = "后台菜单id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "菜单列表名字")
    private String name;

    @ApiModelProperty(value = "菜单的path")
    private String path;

    @ApiModelProperty(value = "菜单的component")
    private String component;

    @ApiModelProperty(value = "菜单图标")
    private String icon;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "排序")
    private Integer orderNum;

    @ApiModelProperty(value = "是否禁用")
    private Integer isDisable;

    @ApiModelProperty(value = "是否隐藏")
    private Integer isHidden;

    @ApiModelProperty(value = "二级菜单目录")
    private List<MenuDTO> children = new ArrayList<>();

}
