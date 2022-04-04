package com.finn.blog.dao;

import com.finn.blog.entity.UserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/*
 * @description:
 * @author: Finn
 * @create: 2022/04/04 00:58
 */
@Repository
public interface UserInfoDao extends BaseMapper<UserInfo> {
//    UserInfo selectById(@Integer userInfoId);
}

