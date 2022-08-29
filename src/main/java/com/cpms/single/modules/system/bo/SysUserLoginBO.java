package com.cpms.single.modules.system.bo;

import com.cpms.framework.common.core.secure.UserLoginBase;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @description: 系统用户登录BO类
 * @author: gulang
 * @time: 2021/6/8 11:04
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysUserLoginBO extends UserLoginBase {
    private static final long serialVersionUID = 1L;

    /**
     * 用户状态： 0-正常，1-已禁用
     */
    private int userStarus;

    /**
     * 租户状态：0-正常，1-已禁用
     */
    private int tenantStatus;

    /**
     * 部门ID
     */
    private Long deptId;

    /**
     * 部门ID
     */
    private String deptName;

    /**
     * 租户ID
     */
    private Long tenantId;

    /**
     * 租户名称
     */
    private String tenantName;

    /**
     * 租户编码
     */
    private String tenantCode;

    /**
     * 用户密码
     */
    private String userPassword;
    /**
     * 岗位名称
     */
    private String postName;

    /**
     * 岗位ID
     */
    private Long postId;


}
