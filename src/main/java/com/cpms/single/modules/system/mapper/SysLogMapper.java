package com.cpms.single.modules.system.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cpms.single.modules.system.dto.QueryLogDTO;
import com.cpms.single.modules.system.entity.SysLogEntity;
import com.cpms.single.modules.system.vo.SysLogVO;

import java.util.List;

/**
 * @author gulang
 * @Description:
 * @time: 2021/8/21 16:09
 */
@DS("master")
public interface SysLogMapper extends BaseMapper<SysLogEntity> {
     int listLogCount(QueryLogDTO listLogDTO);
     List<SysLogVO> listLog(QueryLogDTO listLogDTO);

}
