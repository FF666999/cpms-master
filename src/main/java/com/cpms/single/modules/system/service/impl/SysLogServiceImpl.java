package com.cpms.single.modules.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cpms.framework.common.core.api.Result;
import com.cpms.framework.common.core.api.ResultUtil;
import com.cpms.framework.common.core.base.BasePageVO;
import com.cpms.framework.common.utils.CsBeanUtil;
import com.cpms.framework.common.utils.CsSecureUtil;
import com.cpms.single.common.constants.SystemConstant;
import com.cpms.single.common.dto.HandlerLogDTO;
import com.cpms.single.modules.system.dto.QueryLogDTO;
import com.cpms.single.modules.system.entity.SysLogEntity;
import com.cpms.single.modules.system.mapper.SysLogMapper;
import com.cpms.single.modules.system.service.ISysLogService;
import com.cpms.single.modules.system.vo.SysLogVO;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @author gulang
 * @Description:
 * @time: 2021/8/21 16:07
 */
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLogEntity> implements ISysLogService {
    @Resource
    private  SysLogMapper sysLogMapper;

    @Override
    public BasePageVO<SysLogVO> listLog(QueryLogDTO listLogDTO) {
        BasePageVO<SysLogVO> basePageVO = new BasePageVO();
        List<SysLogVO> list;
        if(Objects.isNull(listLogDTO.getTenantId())) {
            listLogDTO.setTenantId(CsSecureUtil.userTenantId());
        }
        int count = sysLogMapper.listLogCount(listLogDTO);
        if(count == 0){
            list = Lists.newArrayList();
        }else{
            list = sysLogMapper.listLog(listLogDTO);
        }
        basePageVO.setTotal(count);
        basePageVO.setList(list);
        return basePageVO;
    }

    @Override
    public boolean deleteLog(Long logId) {
        LambdaUpdateWrapper<SysLogEntity> updateWrapper = Wrappers.<SysLogEntity>lambdaUpdate()
                .set(SysLogEntity::getDelFlag, SystemConstant.DEL_FLAG_DELETED)
                .eq(SysLogEntity::getLogId,logId)
                .eq(SysLogEntity::getTenantId, CsSecureUtil.userTenantId());
        return this.update(updateWrapper);
    }

    @Override
    public Result<Boolean> recordHandlerLog(HandlerLogDTO handlerLogDTO) {
        SysLogEntity sysLogEntity = new SysLogEntity();
        CsBeanUtil.copyProperties(handlerLogDTO,sysLogEntity);
        return ResultUtil.success(this.save(sysLogEntity));

    }
}
