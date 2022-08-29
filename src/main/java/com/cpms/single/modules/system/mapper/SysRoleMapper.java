package com.cpms.single.modules.system.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cpms.single.modules.system.dto.QueryRoleDTO;
import com.cpms.single.modules.system.entity.SysRoleEntity;
import com.cpms.single.modules.system.vo.SysRoleVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:
 * @author: gulang
 * @time: 2021/8/6 17:10
 */
@DS("master")
public interface SysRoleMapper extends BaseMapper<SysRoleEntity> {
    List<SysRoleEntity> queryRoleByUserId(@Param("userId") Long userId);

    int listRoleCount(QueryRoleDTO listRoleDTO);

    List<SysRoleVO> listRole(QueryRoleDTO listRoleDTO);

    String selectMenuIdByRoleId(Long roleId);
}
