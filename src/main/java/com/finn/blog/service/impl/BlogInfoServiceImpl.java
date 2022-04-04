package com.finn.blog.service.impl;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.finn.blog.service.BlogInfoService;
import com.finn.blog.service.RedisService;
import com.finn.blog.utils.IPUtils;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import static com.finn.blog.constant.CommonConst.*;
import static com.finn.blog.constant.RedisPrefixConst.*;

/*
 * @description: 博客信息服务层实现类
 * @author: Finn
 * @create: 2022/04/04 17:04
 */
@Service
public class BlogInfoServiceImpl implements BlogInfoService {

    @Resource
    private HttpServletRequest request;
    @Autowired
    private RedisService redisService;

    @Override
    public void report() {
        String ipAddress = IPUtils.getIpAddress(request);
        UserAgent userAgent = IPUtils.getUserAgent(request);
        Browser browser = userAgent.getBrowser();
        OperatingSystem operatingSystem = userAgent.getOperatingSystem();
        // 生成唯一标识
        String uuid = ipAddress + browser.getName() + operatingSystem.getName();
        String md5 = DigestUtils.md5DigestAsHex(uuid.getBytes());
        // 判断redis中是否存在
        if (!redisService.sIsMember(UNIQUE_VISITOR, md5)) {
            // 统计游客地域分布
            String ipSource = IPUtils.getIpSource(ipAddress);
            if (StringUtils.isNotBlank(ipSource)) {
                ipSource = ipSource.substring(0, 2)
                        .replaceAll(PROVINCE, "")
                        .replaceAll(CITY, "");
                redisService.hIncr(VISITOR_AREA, ipSource, 1L);
            } else {
                redisService.hIncr(VISITOR_AREA, UNKNOWN, 1L);
            }
            // 访问量+1
            redisService.incr(BLOG_VIEWS_COUNT, 1);
            // 保存唯一标识
            redisService.sAdd(UNIQUE_VISITOR, md5);
        }
    }
}
