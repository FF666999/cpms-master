package com.cpms.single.modules.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cpms.framework.common.core.api.Result;
import com.cpms.framework.common.core.base.BasePageVO;
import com.cpms.single.common.dto.HandlerLogDTO;
import com.cpms.single.modules.system.dto.QueryLogDTO;
import com.cpms.single.modules.system.entity.SysLogEntity;
import com.cpms.single.modules.system.vo.SysLogVO;

/**
 * @author gulang
 * @Description:
 * @time: 2021/8/21 16:05
 */
public interface ISysLogService extends IService<SysLogEntity> {
    BasePageVO<SysLogVO> listLog(QueryLogDTO listLogDTO);
    boolean deleteLog(Long logId);
    Result<Boolean> recordHandlerLog(HandlerLogDTO handlerLogDTO);
}
