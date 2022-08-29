package com.cpms.single.modules.system.vo;

import com.cpms.framework.common.core.base.BaseVO;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @description:
 * @author: gulang
 * @time: 2021/9/15 16:40
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SysUserVO extends BaseVO {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long deptId;
    private String deptName;
    private String userName;
    private String userRealName;
    /**
     * 用户账号
     */
    private String userAccount;

    /**
     * 0-正常，1-已禁用
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Integer userStatus;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long postId;
    private String postName;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long tenantId;
    private String tenantName;
    private String roleNames;
    private String roleIds;
    /**
     * 是否系统数据: 0-不是，1-是
     */
    private Integer sysData;
}
