package com.cpms.single.modules.system.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cpms.single.modules.system.bo.SysUserLoginBO;
import com.cpms.single.modules.system.dto.QueryUserDTO;
import com.cpms.single.modules.auth.dto.SysUserLginDTO;
import com.cpms.single.modules.system.entity.SysUserEntity;
import com.cpms.single.modules.system.vo.SysUserVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:
 * @author: gulang
 * @time: 2021/7/16 19:27
 */
@DS("master")
public interface SysUserMapper extends BaseMapper<SysUserEntity> {
    /**
     *  查询用户信息
     * @param sysUserLginDTO
     * @return
     */
    SysUserLoginBO querySysUserInfo(SysUserLginDTO sysUserLginDTO);

    int listUserCount(@Param("userDto") QueryUserDTO listUserDTO, @Param("depts") List<Long> depts);
    List<SysUserVO> listUser(@Param("userDto") QueryUserDTO listUserDTO, @Param("depts") List<Long> depts);
}
