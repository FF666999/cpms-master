package com.cpms.single.modules.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cpms.single.modules.system.entity.SysRoleUserEntity;
import com.cpms.single.modules.system.mapper.SysRoleUserMapper;
import com.cpms.single.modules.system.service.ISysRoleUserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: gulang
 * @time: 2021/9/15 11:51
 */
@Service
public class SysRoleUserServiceImpl extends ServiceImpl<SysRoleUserMapper, SysRoleUserEntity> implements ISysRoleUserService {

    @Override
    public List<String> queryRoleCodeByUserId(Long userId) {
        return baseMapper.queryRoleCodeByUserId(userId);
    }
}
