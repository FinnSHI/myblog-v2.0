package com.finn.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.finn.blog.dto.TagBackDTO;
import com.finn.blog.dto.TagDTO;
import com.finn.blog.entity.Tag;
import com.finn.blog.dao.TagDao;
import com.finn.blog.service.TagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.finn.blog.utils.BeanCopyUtils;
import com.finn.blog.utils.PageUtils;
import com.finn.blog.vo.ConditionVO;
import com.finn.blog.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author finn
 * @since 2022-04-04
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagDao, Tag> implements TagService {

    @Autowired
    TagDao tagDao;

    @Override
    public List<TagDTO> listTagsBySearch(ConditionVO conditionVO) {
        List<Tag> tagList = tagDao.selectList(new LambdaQueryWrapper<Tag>()
                .like(StringUtils.isNotBlank(conditionVO.getKeywords()), Tag::getTagName, conditionVO.getKeywords())
                .orderByDesc(Tag::getId)
        );
        return BeanCopyUtils.copyList(tagList, TagDTO.class);
    }

    @Override
    public PageResult<TagBackDTO> listTagBackDTO(ConditionVO condition) {
        Integer count = tagDao.selectCount(new LambdaQueryWrapper<Tag>().like(StringUtils.isNotBlank(condition.getKeywords()), Tag::getTagName, condition.getKeywords()));
        if(count == 0) {
            return new PageResult<>();
        }
        List<TagBackDTO> tagBackDTOS = tagDao.listTagBackDTO(PageUtils.getLimitCurrent(), PageUtils.getSize(), condition);
        return new PageResult<>(tagBackDTOS, count);
    }

    @Override
    public PageResult<TagDTO> listTags() {
        List<Tag> tags = tagDao.selectList(null);
        List<TagDTO> tagDTOList = BeanCopyUtils.copyList(tags, TagDTO.class);
        return new PageResult<>(tagDTOList, tagDao.selectCount(null));
    }
}
