package com.finn.blog.service;

import com.finn.blog.dto.TagBackDTO;
import com.finn.blog.dto.TagDTO;
import com.finn.blog.entity.Tag;
import com.baomidou.mybatisplus.extension.service.IService;
import com.finn.blog.vo.ConditionVO;
import com.finn.blog.vo.PageResult;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author finn
 * @since 2022-04-04
 */
public interface TagService extends IService<Tag> {

    /*
    * @Description: 搜索文章Tags
    * @Param: [conditionVO]
    * @return: java.util.List<com.finn.blog.dto.TagDTO>
    * @Author: Finn
    * @Date: 2022/04/05 00:22
    */
    List<TagDTO> listTagsBySearch(ConditionVO conditionVO);

    /* 
    * @Description: 后台tag列表 
    * @Param: [condition] 
    * @return: com.finn.blog.vo.PageResult<com.finn.blog.dto.TagBackDTO> 
    * @Author: Finn
    * @Date: 2022/04/05 10:19
    */
    PageResult<TagBackDTO> listTagBackDTO(ConditionVO condition);
}
