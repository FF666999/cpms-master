package com.cpms.single.modules.system.controller;

import com.cpms.framework.common.core.api.Result;
import com.cpms.framework.common.core.api.ResultUtil;
import com.cpms.framework.mybatis.groups.AddGroup;
import com.cpms.framework.mybatis.groups.DeleteGroup;
import com.cpms.framework.mybatis.groups.OtherGroup;
import com.cpms.framework.mybatis.groups.UpdateGroup;
import com.cpms.single.modules.system.dto.SysTopMenuDTO;
import com.cpms.single.modules.system.service.ISysTopMenuService;
import com.cpms.single.modules.system.vo.SysTopMenuVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: gulang
 * @time: 2021/8/6 15:13
 */
@RestController
@RequestMapping("/sys-top-menu")
public class SysTopMenuController {
    @Resource
    private ISysTopMenuService sysTopMenuService;

    /**
     *  顶部菜单列表
     * @return
     */
    @GetMapping("/list")
    public Result<List<SysTopMenuVO>> listTopMenu(){
        return ResultUtil.success(sysTopMenuService.listTopMenu());
    }

    /**
     *  获取顶部菜单路由
     * @return
     */
    @PostMapping("/top-menu")
    public Result<List<SysTopMenuVO>> getTopMenu(){
        return ResultUtil.success(sysTopMenuService.getTopMenu());
    }

    /**
     *  添加菜单
     * @return
     */
    @PostMapping("/add")
    public Result<Void> addTopMenu(@Validated(AddGroup.class) @RequestBody SysTopMenuDTO sysTopMenuDTO){
        return ResultUtil.status(sysTopMenuService.addTopMenu(sysTopMenuDTO));
    }

    /**
     *  更新操作
     * @param sysTopMenuDTO
     * @return
     */
    @PostMapping("/update")
    public Result<Void> updateTopMenu(@Validated(UpdateGroup.class) @RequestBody SysTopMenuDTO sysTopMenuDTO){
        return ResultUtil.status(sysTopMenuService.updateTopMenu(sysTopMenuDTO));
    }

    /**
     *  删除操作
     * @param sysTopMenuDTO
     * @return
     */
    @PostMapping("/delete")
    public Result<Void> deleteTopMenu(@Validated(DeleteGroup.class) @RequestBody SysTopMenuDTO sysTopMenuDTO){
        return ResultUtil.status(sysTopMenuService.deleteTopMenu(sysTopMenuDTO));
    }

    /**
     *  配置顶部菜单的下级菜单
     * @param sysTopMenuDTO
     * @return
     */
    @PostMapping("/configTopMenu")
    public Result<Void> configTopMenu(@Validated(OtherGroup.class) @RequestBody SysTopMenuDTO sysTopMenuDTO){
        return ResultUtil.status(sysTopMenuService.configTopMenu(sysTopMenuDTO));
    }
}
