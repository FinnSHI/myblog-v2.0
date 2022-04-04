package com.finn.blog.service.impl;

import com.finn.blog.dto.ArticleBackDTO;
import com.finn.blog.entity.Article;
import com.finn.blog.dao.ArticleDao;
import com.finn.blog.service.ArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.finn.blog.service.RedisService;
import com.finn.blog.utils.PageUtils;
import com.finn.blog.vo.ArticleTopVO;
import com.finn.blog.vo.ArticleVO;
import com.finn.blog.vo.ConditionVO;
import com.finn.blog.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import static com.finn.blog.constant.RedisPrefixConst.ARTICLE_LIKE_COUNT;
import static com.finn.blog.constant.RedisPrefixConst.ARTICLE_VIEWS_COUNT;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author finn
 * @since 2022-04-04
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleDao, Article> implements ArticleService {

    @Autowired
    ArticleDao articleDao;
    @Autowired
    RedisService redisService;

    @Override
    public PageResult<ArticleBackDTO> listArticleBacks(ConditionVO conditionVO) {
        Integer count = articleDao.countArticleBacks(conditionVO);
        if(count == 0) {
            return new PageResult<>();
        }
        // 查询后台文章
        List<ArticleBackDTO> articleBackDTOList = articleDao.listArticleBacks(PageUtils.getLimitCurrent(), PageUtils.getSize(), conditionVO);
        // 查询文章点赞量
        Map<String, Object> likeCountMap = redisService.hGetAll(ARTICLE_LIKE_COUNT);
        // 查询文章浏览量
        Map<Object, Double> viewsCountMap = redisService.zAllScore(ARTICLE_VIEWS_COUNT);
        // 封装点赞量和浏览量
        articleBackDTOList.forEach(item -> {
            Double viewsCount = viewsCountMap.get(item.getId());
            if (Objects.nonNull(viewsCount)) {
                item.setViewsCount(viewsCount.intValue());
            }
            item.setLikeCount((Integer) likeCountMap.get(item.getId().toString()));
        });
        return new PageResult<>(articleBackDTOList, count);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateArticleTop(ArticleTopVO articleTopVO) {
        // 修改文章置顶状态
        Article article = Article.builder()
                .id(articleTopVO.getId())
                .isTop(articleTopVO.getIsTop())
                .build();
        articleDao.updateById(article);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveOrUpdateArticle(ArticleVO articleVO) {

    }
}
