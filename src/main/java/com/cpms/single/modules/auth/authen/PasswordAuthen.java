package com.cpms.single.modules.auth.authen;

import com.cpms.framework.common.core.secure.AuthInfo;
import com.cpms.framework.common.core.secure.TokenInfo;
import com.cpms.framework.common.exception.BizException;
import com.cpms.framework.common.utils.CsJwtUtil;
import com.cpms.framework.redis.utils.CsRedisUtil;
import com.cpms.single.common.constants.RedisKeyConstant;
import com.cpms.single.common.constants.SystemConstant;
import com.cpms.single.common.enums.RespResultEnum;
import com.cpms.single.modules.auth.dto.SysUserLginDTO;
import com.cpms.single.modules.auth.dto.UserLoginDTO;
import com.cpms.single.modules.system.service.ISysUserService;
import com.cpms.single.modules.system.vo.SysRoleVO;
import com.cpms.single.modules.system.vo.SysUserLoginVO;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @description: 账号密码授权
 * @author: gulang
 * @time: 2021/6/7 19:43
 */
@Component
public class PasswordAuthen implements IAuthen{
    @Resource
    private ISysUserService sysUserService;

    public static final String GRANT_TYPE = "password";

    @Override
    public AuthInfo authentication(UserLoginDTO userLoginDTO) {
        if(!userLoginDTO.getCaptcha().equalsIgnoreCase(
                CsRedisUtil.get(String.format(RedisKeyConstant.UserLogin.CAPTCHA_KEY, userLoginDTO.getCodeKey())))){
            throw new BizException(RespResultEnum.CAPTCHA_VERIFICATION_EEROR);
        }
        SysUserLginDTO sysUserLginDTO = new SysUserLginDTO();
        sysUserLginDTO.setUserAccount(userLoginDTO.getAccount());
        sysUserLginDTO.setUserPassword(userLoginDTO.getPassword());
        SysUserLoginVO sysUserLoginVO = sysUserService.sysUserLogin(sysUserLginDTO);
        if(StringUtils.isBlank(sysUserLoginVO.getUserAvatar())) {
            sysUserLoginVO.setUserAvatar(SystemConstant.DEFAULT_AVATAR);
        }
        AuthInfo authInfo = new AuthInfo();
        Map<String, Object> claims = buildJwtClaims(sysUserLoginVO);
        TokenInfo tokenInfo = CsJwtUtil.createJwt(claims);
        authInfo.setAccessToken(tokenInfo.getToken());
        authInfo.setExpire(tokenInfo.getExpire());
        authInfo.setUserInfo(sysUserLoginVO);
        return authInfo;
    }

    private Map<String, Object> buildJwtClaims(SysUserLoginVO sysUserLoginVO){
        Map<String, Object> claims = Maps.newHashMap();
        claims.put("userAccount",sysUserLoginVO.getUserAccount());
        claims.put("userName",sysUserLoginVO.getUserName());
        claims.put("userId",sysUserLoginVO.getUserId());
        claims.put("userMobile",sysUserLoginVO.getUserMobile());
        claims.put("deptId",sysUserLoginVO.getDeptId());
        claims.put("tenantId",sysUserLoginVO.getTenantId());
        claims.put("tenantCode",sysUserLoginVO.getTenantCode());
        claims.put("postId",sysUserLoginVO.getPostId());
        claims.put("userSex",sysUserLoginVO.getUserSex());
        claims.put("roleCodes",sysUserLoginVO.getRoles().stream().map(SysRoleVO::getRoleCode).collect(Collectors.toList()));
        claims.put("roleIds",sysUserLoginVO.getRoles().stream().map(SysRoleVO::getRoleId).collect(Collectors.toList()));
        return claims;
    }
}
