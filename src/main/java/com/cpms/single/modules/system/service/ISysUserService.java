package com.cpms.single.modules.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cpms.framework.common.core.base.BasePageVO;
import com.cpms.single.modules.auth.dto.SysUserLginDTO;
import com.cpms.single.modules.system.bo.SysUserLoginBO;
import com.cpms.single.modules.system.dto.*;
import com.cpms.single.modules.system.entity.SysUserEntity;
import com.cpms.single.modules.system.vo.SysUserDetailVO;
import com.cpms.single.modules.system.vo.SysUserLoginVO;
import com.cpms.single.modules.system.vo.SysUserVO;

/**
 * @description:
 * @author: gulang
 * @time: 2021/7/16 19:30
 */
public interface ISysUserService extends IService<SysUserEntity> {
    /**
     * 系统登录
     * @param sysUserLginDTO
     * @return
     */
    SysUserLoginVO sysUserLogin(SysUserLginDTO sysUserLginDTO);
    /**
     * 用户列表
     * @param listUserDTO
     * @return
     */
    BasePageVO<SysUserVO> listUser(QueryUserDTO listUserDTO);

    /**
     * 获取用户详情
     * @param userDTO
     * @return
     */
    SysUserDetailVO getUserDetail(SysUserDTO userDTO);

    /**
     * 查看用户信息
     * @param userDTO
     * @return
     */
    SysUserDetailVO checkUserInfo(SysUserDTO userDTO);

    /**
     *  登录用户信息查询
     * @param sysUserLginDTO
     * @return
     */
    SysUserLoginBO querySysUserInfo(SysUserLginDTO sysUserLginDTO);

    /**
     * 删除用户
     * @param userDTO
     * @return
     */
    boolean deleteUser(SysUserDTO userDTO);

    /**
     * 新增用户
     * @param userDTO
     * @return
     */
    boolean addUser(SysUserDTO userDTO);

    /**
     * 更新用户
     * @param userDTO
     * @return
     */
    boolean updateUser(SysUserDTO userDTO);

    /**
     * 用户重置个人密码
     * @param resetPasswordDTO
     * @return
     */
    boolean resetPassword(ResetPasswordDTO resetPasswordDTO);

    /**
     * 管理员修改用户密码
     * @param resetPasswordDTO
     * @return
     */
    boolean modifiedPassword(ResetPasswordDTO resetPasswordDTO);

    int userCount(Long tenantId);

    String generateAccount(SysUserDTO userDTO);

    boolean changeUserStatus(Long userId, Integer userStatus);
    boolean modifiedPersonalInfo(PersonalInfoDTO personalInfoDTO);
}
