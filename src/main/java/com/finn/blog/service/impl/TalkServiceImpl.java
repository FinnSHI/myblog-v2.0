package com.finn.blog.service.impl;

import com.finn.blog.entity.Talk;
import com.finn.blog.dao.TalkDao;
import com.finn.blog.service.TalkService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author finn
 * @since 2022-04-13
 */
@Service
public class TalkServiceImpl extends ServiceImpl<TalkDao, Talk> implements TalkService {

}
