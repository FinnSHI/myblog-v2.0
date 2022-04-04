package com.finn.blog.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/*
 * @description: 分页结果
 * @author: Finn
 * @create: 2022/04/04 21:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(description = "分页对象")
public class PageResult<T> {

    /**
     * 分页列表
     */
    @ApiModelProperty(name = "recordList", value = "分页列表", required = true, dataType = "List<T>")
    private List<T> recordList;

    /**
     * 总数
     */
    @ApiModelProperty(name = "count", value = "总数", required = true, dataType = "Integer")
    private Integer count;

}