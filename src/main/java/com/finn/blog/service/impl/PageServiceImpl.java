package com.finn.blog.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.finn.blog.dao.PageDao;
import com.finn.blog.entity.Page;
import com.finn.blog.service.PageService;
import com.finn.blog.service.RedisService;
import com.finn.blog.utils.BeanCopyUtils;
import com.finn.blog.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

import static com.finn.blog.constant.RedisPrefixConst.*;

/*
 * @description: 页面服务层
 * @author: Finn
 * @create: 2022/04/05 19:24
 */
@Service
public class PageServiceImpl extends ServiceImpl<PageDao, Page> implements PageService {

    @Autowired
    private RedisService redisService;
    @Autowired
    private PageDao pageDao;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<PageVO> listPages() {
        List<PageVO> pageVOList;
        // 查找缓存信息，不存在则从mysql读取，更新缓存
        Object pageList = redisService.get(PAGE_COVER);
        if (Objects.nonNull(pageList)) {
            pageVOList = JSON.parseObject(pageList.toString(), List.class);
        } else {
            pageVOList = BeanCopyUtils.copyList(pageDao.selectList(null), PageVO.class);
            redisService.set(PAGE_COVER, JSON.toJSONString(pageVOList));
        }
        return pageVOList;
    }
}
