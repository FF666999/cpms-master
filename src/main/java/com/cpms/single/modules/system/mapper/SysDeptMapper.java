package com.cpms.single.modules.system.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cpms.single.modules.system.dto.QueryDeptDTO;
import com.cpms.single.modules.system.entity.SysDeptEntity;
import com.cpms.single.modules.system.vo.SysDeptVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:
 * @author: gulang
 * @time: 2021/7/20 17:51
 */
@DS("master")
public interface SysDeptMapper extends BaseMapper<SysDeptEntity> {
    int listDeptCount(QueryDeptDTO listDeptDTO);

    List<SysDeptVO> listDept(QueryDeptDTO listDeptDTO);

    List<SysDeptEntity> findTenantDeptNodes(@Param("deptId") Long deptId, @Param("tenantId") Long tenantId);
}
