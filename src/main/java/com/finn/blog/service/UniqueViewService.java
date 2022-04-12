package com.finn.blog.service;

import com.finn.blog.dto.UniqueViewDTO;
import com.finn.blog.entity.UniqueView;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author finn
 * @since 2022-04-12
 */
public interface UniqueViewService extends IService<UniqueView> {

    /*
    * @Description: 获取7天用户量统计
    * @Param: []
    * @return: java.util.List<com.finn.blog.dto.UniqueViewDTO>
    * @Author: Finn
    * @Date: 2022/04/12 13:27
    */
    List<UniqueViewDTO> listUniqueViews();
}
