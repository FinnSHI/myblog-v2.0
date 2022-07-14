package com.finn.blog.service;

import com.finn.blog.dto.OperationLogDTO;
import com.finn.blog.entity.OperationLog;
import com.baomidou.mybatisplus.extension.service.IService;
import com.finn.blog.vo.ConditionVO;
import com.finn.blog.vo.PageResult;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author finn
 * @since 2022-04-08
 */
public interface OperationLogService extends IService<OperationLog> {

    /**
     * 查询日志列表
     *
     * @param conditionVO 条件
     * @return 日志列表
     */
    PageResult<OperationLogDTO> listOperationLogs(ConditionVO conditionVO);
}
