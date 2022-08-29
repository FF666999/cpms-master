package com.cpms.single.modules.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cpms.framework.common.core.base.BasePageVO;
import com.cpms.single.modules.system.dto.QueryDeptDTO;
import com.cpms.single.modules.system.dto.SysDeptDTO;
import com.cpms.single.modules.system.entity.SysDeptEntity;
import com.cpms.single.modules.system.vo.DeptTreeVO;
import com.cpms.single.modules.system.vo.SysDeptVO;

import java.util.List;

/**
 * @description:
 * @author: gulang
 * @time: 2021/7/20 17:52
 */
public interface ISysDeptService extends IService<SysDeptEntity> {
    BasePageVO<SysDeptVO> listDept(QueryDeptDTO listDeptDTO);
    boolean addDept(SysDeptDTO deptDTO);
    boolean updateDept(SysDeptDTO deptDTO);
    boolean deleteDept(SysDeptDTO deptDTO);
    List<DeptTreeVO> allDeptTree(QueryDeptDTO queryDeptDTO);
    List<DeptTreeVO> tenantDeptTree();
    List<SysDeptEntity> findTenantDeptNodes(Long deptId, Long tenantId);
}
