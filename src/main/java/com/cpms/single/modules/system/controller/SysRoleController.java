package com.cpms.single.modules.system.controller;

import com.cpms.framework.common.core.api.Result;
import com.cpms.framework.common.core.api.ResultUtil;
import com.cpms.framework.common.core.base.BasePageVO;
import com.cpms.framework.mybatis.groups.AddGroup;
import com.cpms.framework.mybatis.groups.DeleteGroup;
import com.cpms.framework.mybatis.groups.OtherGroup;
import com.cpms.framework.mybatis.groups.UpdateGroup;
import com.cpms.framework.secure.annotations.PreAuth;
import com.cpms.single.modules.system.dto.QueryRoleDTO;
import com.cpms.single.modules.system.dto.SysRoleDTO;
import com.cpms.single.modules.system.service.ISysRoleService;
import com.cpms.single.modules.system.vo.SysRoleVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @description:
 * @author: gulang
 * @time: 2021/8/6 15:13
 */
@RestController
@RequestMapping("/sys-role")
public class SysRoleController {
    @Resource
    private ISysRoleService sysRoleService;


    /**
     *  获取角色列表
     * @param listRoleDTO
     * @return
     */
    @PostMapping("/list")
    @PreAuth("sys_role_view,sys_user_add,sys_user_edit")
    public Result<BasePageVO<SysRoleVO>> listRole(@RequestBody QueryRoleDTO listRoleDTO){
        return ResultUtil.success(sysRoleService.listRole(listRoleDTO));
    }

    /**
     *  添加菜单
     * @param sysRoleDTO
     * @return
     */
    @PostMapping("/addRole")
    @PreAuth("sys_role_add")
    public Result<Void> addRole(@Validated(AddGroup.class) @RequestBody SysRoleDTO sysRoleDTO){
        return ResultUtil.status(sysRoleService.addRole(sysRoleDTO));
    }

    /**
     *  更新操作
     * @param sysRoleDTO
     * @return
     */
    @PostMapping("/updateRole")
    @PreAuth("sys_role_edit")
    public Result<Void> updateRole(@Validated(UpdateGroup.class) @RequestBody SysRoleDTO sysRoleDTO){
        return ResultUtil.status(sysRoleService.updateRole(sysRoleDTO));
    }

    /**
     *  删除操作
     * @param sysRoleDTO
     * @return
     */
    @PostMapping("/deleteRole")
    @PreAuth("sys_role_delete")
    public Result<Void> deleteRole(@Validated(DeleteGroup.class) @RequestBody SysRoleDTO sysRoleDTO){
        return ResultUtil.status(sysRoleService.deleteRole(sysRoleDTO));
    }

    /**
     *  配置角色权限
     * @param sysRoleDTO
     * @return
     */
    @PostMapping("/configRolePer")
    @PreAuth("sys_role_config_per")
    public Result<Void> configRolePer(@Validated(OtherGroup.class)@RequestBody SysRoleDTO sysRoleDTO){
        return ResultUtil.status(sysRoleService.configRolePer(sysRoleDTO));
    }
}
