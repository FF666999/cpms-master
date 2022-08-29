package com.cpms.single.modules.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cpms.framework.common.core.base.BasePageVO;
import com.cpms.single.modules.system.dto.QueryTenantDTO;
import com.cpms.single.modules.system.dto.SysTenantDTO;
import com.cpms.single.modules.system.entity.SysTenantEntity;
import com.cpms.single.modules.system.vo.InitTenantAccountVO;
import com.cpms.single.modules.system.vo.SysTenantVO;

import java.util.List;


/**
 * @description:
 * @author: gulang
 * @time: 2021/9/22 11:27
 */
public interface ISysTenantService extends IService<SysTenantEntity> {
    InitTenantAccountVO addTenant(SysTenantDTO tenantDTO);
    boolean updateTenant(SysTenantDTO tenantDTO);
    boolean deleteTenant(SysTenantDTO tenantDTO);
    BasePageVO<SysTenantVO> listTenant(QueryTenantDTO listTenantDTO);
    List<SysTenantVO> dropDownTenants();
    boolean configTenantPer(SysTenantDTO tenantDTO);
    boolean changeTenantStatus(Long tenantId, Integer tenantStatus);
}
