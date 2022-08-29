package com.cpms.single.modules.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cpms.framework.common.core.base.BasePageVO;
import com.cpms.single.modules.system.dto.QueryRoleDTO;
import com.cpms.single.modules.system.dto.SysRoleDTO;
import com.cpms.single.modules.system.entity.SysRoleEntity;
import com.cpms.single.modules.system.vo.SysRoleVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:
 * @author: gulang
 * @time: 2021/8/6 17:50
 */
public interface ISysRoleService extends IService<SysRoleEntity> {
    List<SysRoleEntity> queryRoleByUserId(@Param("userId") Long userId);
    BasePageVO<SysRoleVO> listRole(QueryRoleDTO listRoleDTO);
    boolean addRole(SysRoleDTO sysRoleDTO);
    boolean updateRole(SysRoleDTO sysRoleDTO);
    boolean deleteRole(SysRoleDTO sysRoleDTO);
    boolean configRolePer(SysRoleDTO sysRoleDTO);
    boolean saveRoleMenu(String menuIds, Long roleId);
}
