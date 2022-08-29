package com.cpms.single.modules.system.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cpms.single.modules.system.entity.SysRoleMenuEntity;

/**
 * @author gulang
 * @Description:
 * @time: 2021/11/10 21:23
 */
@DS("master")
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenuEntity> {
}
