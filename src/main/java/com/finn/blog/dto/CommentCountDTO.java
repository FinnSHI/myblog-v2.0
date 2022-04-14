package com.finn.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * @description: 评论数量
 * @author: Finn
 * @create: 2022/04/13 19:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentCountDTO {

    /**
     * id
     */
    private Integer id;

    /**
     * 评论数量
     */
    private Integer commentCount;
}

