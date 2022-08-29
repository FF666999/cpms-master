package com.cpms.single.modules.system.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author gulang
 * @Description:
 * @time: 2021/10/21 20:37
 */
@Data
public class SysUserDetailVO {

    @JsonFormat( pattern = "yyyy-MM-dd" ,timezone="GMT+8")
    private LocalDate userBirthday;
    /**
     * 用户头像
     */
    private String userAvatar;
    /**
     * 用户手机号
     */
    private String userMobile;
    /**
     * 用户性别：0-未知，1-男，2-女
     */
    private Integer userSex;
    private String userRealName;
    private String userName;
}
