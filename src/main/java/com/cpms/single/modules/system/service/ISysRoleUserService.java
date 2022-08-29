package com.cpms.single.modules.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cpms.single.modules.system.entity.SysRoleUserEntity;

import java.util.List;

/**
 * @description:
 * @author: gulang
 * @time: 2021/9/15 11:50
 */
public interface ISysRoleUserService extends IService<SysRoleUserEntity> {
    List<String> queryRoleCodeByUserId(Long userId);
}
