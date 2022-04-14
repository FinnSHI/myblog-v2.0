package com.finn.blog.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/*
 * @description: 评论类型枚举
 * @author: Finn
 * @create: 2022/04/13 11:48
 */
@Getter
@AllArgsConstructor
public enum CommentTypeEnum {

    /**
     * 文章评论
     */
    ARTICLE(1, "文章评论", "/articles/"),
    /**
     * 友链评论
     */
    LINK(2, "友链评论", "/links/"),
    /**
     * 说说评论
     */
    TALK(3, "说说评论", "/talks/");

    /**
     * 状态
     */
    private final Integer type;

    /**
     * 描述
     */
    private final String desc;

    /**
     * 路径
     */
    private final String path;

    /* 
    * @Description: 获取评论路径 
    * @Param: [type] 
    * @return: java.lang.String 
    * @Author: Finn
    * @Date: 2022/04/13 11:50
    */
    public static String getCommentPath(Integer type) {
        for(CommentTypeEnum typeEnum : CommentTypeEnum.values()) {
            if(typeEnum.getType().equals(type)) {
                return typeEnum.getPath();
            }
        }
        return null;
    }

    /*
    * @Description: 获取评论枚举
    * @Param: [type]
    * @return: java.lang.String
    * @Author: Finn
    * @Date: 2022/04/13 11:54
    */
    public static CommentTypeEnum getCommentEnum(Integer type) {
        for(CommentTypeEnum typeEnum : CommentTypeEnum.values()) {
            if(typeEnum.getType().equals(type)) {
                return typeEnum;
            }
        }
        return null;
    }

}
