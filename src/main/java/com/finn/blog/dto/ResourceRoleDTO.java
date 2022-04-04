package com.finn.blog.dto;

import lombok.Data;

import java.util.List;

/*
 * @description: ResourceRoleDTO
 * @author: Finn
 * @create: 2022/04/04 00:36
 */
@Data
public class ResourceRoleDTO {

    /**
     * 资源id
     */
    private Integer id;

    /**
     * 路径
     */
    private String url;

    /**
     * 请求方式
     */
    private String requestMethod;

    /**
     * 角色名
     */
    private List<String> roleList;

}
