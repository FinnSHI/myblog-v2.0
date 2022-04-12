package com.finn.blog.service;

import com.finn.blog.dto.BlogBackInfoDTO;
import com.finn.blog.dto.BlogHomeInfoDTO;
import com.finn.blog.vo.WebsiteConfigVO;

/*
 * @description: 博客信息服务层
 * @author: Finn
 * @create: 2022/04/04 17:03
 */
public interface BlogInfoService {

    /* 
    * @Description: 上传访客信息
    * @Param: [] 
    * @return: void 
    * @Author: Finn
    * @Date: 2022/04/04 17:06
    */
    void report();

    /* 
    * @Description: 获取首页数据
    * @Param: [] 
    * @return: com.finn.blog.dto.BlogHomeInfoDTO 
    * @Author: Finn
    * @Date: 2022/04/05 19:18
    */
    BlogHomeInfoDTO getBlogHomeInfo();

    /* 
    * @Description: 获取网页配置 
    * @Param: [] 
    * @return: com.finn.blog.vo.WebsiteConfigVO 
    * @Author: Finn
    * @Date: 2022/04/05 19:28
    */
    WebsiteConfigVO getWebsiteConfig();

    /* 
    * @Description: 获取关于我的内容
    * @Param: [] 
    * @return: java.lang.String 
    * @Author: Finn
    * @Date: 2022/04/08 21:54
    */
    String getAbout();

    /*
    * @Description: 查看后台信息
    * @Param: []
    * @return: com.finn.blog.dto.BlogBackInfoDTO
    * @Author: Finn
    * @Date: 2022/04/12 12:58
    */
    BlogBackInfoDTO getBlogBackInfo();
}
