package com.finn.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * @description: 上下篇文章
 * @author: Finn
 * @create: 2022/04/05 21:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticlePaginationDTO {

    /**
     * id
     */
    private Integer id;

    /**
     * 文章缩略图
     */
    private String articleCover;

    /**
     * 标题
     */
    private String articleTitle;

}