package com.cpms.single.modules.system.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cpms.single.modules.system.dto.QueryTenantDTO;
import com.cpms.single.modules.system.entity.SysTenantEntity;
import com.cpms.single.modules.system.vo.SysTenantVO;

import java.util.List;

/**
 * @description:
 * @author: gulang
 * @time: 2021/9/22 11:26
 */
@DS("master")
public interface SysTenantMapper extends BaseMapper<SysTenantEntity> {
    int listTenantCount(QueryTenantDTO listTenantDTO);

    List<SysTenantVO> listTenant(QueryTenantDTO listTenantDTO);
}
