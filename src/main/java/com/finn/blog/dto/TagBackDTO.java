package com.finn.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/*
 * @description: 返回给前端Tag
 * @author: Finn
 * @create: 2022/04/05 10:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TagBackDTO {
    /**
     * 标签id
     */
    private Integer id;

    /**
     * 标签名
     */
    private String tagName;

    /**
     * 文章量
     */
    private Integer articleCount;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

}