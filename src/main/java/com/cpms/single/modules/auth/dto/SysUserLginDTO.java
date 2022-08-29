package com.cpms.single.modules.auth.dto;

import lombok.Data;

/**
 * @author gualng
 * @Description:
 */
@Data
public class SysUserLginDTO {
    /**
     * 登录用户账号
     */
    private String userAccount;
    /**
     * 登录用户密码
     */
    private String userPassword;
}
