package com.cpms.single.modules.system.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cpms.single.modules.system.entity.SysRoleUserEntity;

import java.util.List;

/**
 * @description:
 * @author: gulang
 * @time: 2021/9/15 11:40
 */
@DS("master")
public interface SysRoleUserMapper extends BaseMapper<SysRoleUserEntity> {
    List<String> queryRoleCodeByUserId(Long userId);
}
