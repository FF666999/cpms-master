package com.cpms.single.modules.auth.authen;

import com.cpms.framework.common.core.secure.AuthInfo;
import com.cpms.single.modules.auth.dto.UserLoginDTO;

/**
 * @description: 认证接口类
 * @author: gulang
 * @time: 2021/6/7 19:18
 */
public interface IAuthen {
    AuthInfo authentication(UserLoginDTO userLoginDTO);
}
