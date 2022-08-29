package com.cpms.single.modules.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cpms.framework.common.core.base.BasePageVO;
import com.cpms.framework.common.core.node.NodeManager;
import com.cpms.framework.common.exception.BizException;
import com.cpms.framework.common.utils.CsBeanUtil;
import com.cpms.framework.common.utils.CsSecureUtil;
import com.cpms.single.common.constants.SystemConstant;
import com.cpms.single.common.enums.RespResultEnum;
import com.cpms.single.modules.system.dto.QueryDeptDTO;
import com.cpms.single.modules.system.dto.SysDeptDTO;
import com.cpms.single.modules.system.entity.SysDeptEntity;
import com.cpms.single.modules.system.mapper.SysDeptMapper;
import com.cpms.single.modules.system.service.ISysDeptService;
import com.cpms.single.modules.system.vo.DeptTreeVO;
import com.cpms.single.modules.system.vo.SysDeptVO;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: gulang
 * @time: 2021/7/20 17:54
 */
@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDeptEntity> implements ISysDeptService {
    @Resource
    private SysDeptMapper sysDeptMapper;

    @Override
    public BasePageVO<SysDeptVO> listDept(QueryDeptDTO listDeptDTO) {
        BasePageVO<SysDeptVO> basePageVO = new BasePageVO();
        List<SysDeptVO> list;
        listDeptDTO.setTenantId(CsSecureUtil.userTenantId());
        int count = sysDeptMapper.listDeptCount(listDeptDTO);
        if(count ==0){
            list = Lists.newArrayList();
        }else{
            list = sysDeptMapper.listDept(listDeptDTO);
        }
        basePageVO.setTotal(count);
        basePageVO.setList(list);
        return basePageVO;
    }

    @Override
    public boolean addDept(SysDeptDTO deptDTO) {
        SysDeptEntity sysDeptEntity = new SysDeptEntity();
        CsBeanUtil.copyProperties(deptDTO,sysDeptEntity);
        sysDeptEntity.setTenantId(CsSecureUtil.userTenantId());
        return this.save(sysDeptEntity);
    }

    @Override
    public boolean updateDept(SysDeptDTO deptDTO) {
        LambdaUpdateWrapper<SysDeptEntity> updateWrapper = Wrappers.<SysDeptEntity>lambdaUpdate()
                .set(SysDeptEntity::getDeptName, deptDTO.getDeptName())
                .set(SysDeptEntity::getParentId, deptDTO.getParentId())
                .set(SysDeptEntity::getDeptSort, deptDTO.getDeptSort())
                .set(SysDeptEntity::getDeptDesc, deptDTO.getDeptDesc())
                .eq(SysDeptEntity::getDeptId,deptDTO.getDeptId())
                .eq(SysDeptEntity::getTenantId,CsSecureUtil.userTenantId());
        return this.update(new SysDeptEntity(),updateWrapper);
    }

    @Override
    public boolean deleteDept(SysDeptDTO deptDTO) {
        QueryWrapper<SysDeptEntity> query = Wrappers.query();
        query.eq("parent_id",deptDTO.getDeptId());
        query.eq("del_flag", SystemConstant.DEL_FLAG_NOT_DELETED);
        Integer count = baseMapper.selectCount(query);
        if(count > 0){
            throw new BizException(RespResultEnum.THERE_ARE_CHILD_NODES_ERROR);
        }
        LambdaUpdateWrapper<SysDeptEntity> updateWrapper = Wrappers.<SysDeptEntity>lambdaUpdate()
                .set(SysDeptEntity::getDelFlag, SystemConstant.DEL_FLAG_DELETED)
                .eq(SysDeptEntity::getDeptId,deptDTO.getDeptId())
                .eq(SysDeptEntity::getTenantId,CsSecureUtil.userTenantId())
                .ne(SysDeptEntity::getParentId,0);
        return this.update(updateWrapper);
    }

    @Override
    public List<DeptTreeVO> allDeptTree(QueryDeptDTO queryDeptDTO) {
        QueryWrapper<SysDeptEntity> query = Wrappers.query();
        query.select("tenant_id","dept_id","dept_name","parent_id");
        if(CsSecureUtil.isHeadquarters()) {
            if(!Objects.isNull(queryDeptDTO.getTenantId())) {
                query.eq("tenant_id",   queryDeptDTO.getTenantId());
            }
        }else{
            query.eq("tenant_id", CsSecureUtil.userTenantId());
        }
        query.eq("del_flag", SystemConstant.DEL_FLAG_NOT_DELETED);
        query.orderByAsc("create_time");
        return buildDeptTree(this.list(query));
    }

    private List<DeptTreeVO> buildDeptTree(List<SysDeptEntity> list){
        List<DeptTreeVO> treeNodes = list.stream().map(e -> {
            DeptTreeVO node = new DeptTreeVO();
            node.setDeptName(e.getDeptName());
            node.setDeptId(e.getDeptId());
            node.setId(e.getDeptId());
            node.setParentId(e.getParentId());
            return node;
        }).collect(Collectors.toList());
        List<DeptTreeVO> deptTreeVO = NodeManager.buildTreeNode(treeNodes, 0L);
        return  deptTreeVO;
    }
    @Override
    public List<DeptTreeVO> tenantDeptTree() {
        QueryWrapper<SysDeptEntity> query = Wrappers.query();
        query.select("tenant_id","dept_id","dept_name","parent_id");
        query.eq("tenant_id", CsSecureUtil.userTenantId());
        query.eq("del_flag", SystemConstant.DEL_FLAG_NOT_DELETED);
        query.orderByDesc("dept_sort");
        return buildDeptTree(this.list(query));
    }


    @Override
    public List<SysDeptEntity> findTenantDeptNodes(Long deptId, Long tenantId) {
        return sysDeptMapper.findTenantDeptNodes(deptId, tenantId);
    }
}
