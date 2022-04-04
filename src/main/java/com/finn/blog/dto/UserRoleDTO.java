package com.finn.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * @description: UserRoleDTO
 * @author: Finn
 * @create: 2022/04/04 00:32
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRoleDTO {

    /**
     * 角色id
     */
    private Integer id;

    /**
     * 角色名
     */
    private String roleName;

}
