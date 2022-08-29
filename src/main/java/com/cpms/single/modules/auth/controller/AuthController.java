package com.cpms.single.modules.auth.controller;

import com.cpms.framework.common.core.api.Result;
import com.cpms.framework.common.core.api.ResultUtil;
import com.cpms.framework.common.core.secure.AuthInfo;
import com.cpms.framework.redis.utils.CsRedisUtil;
import com.cpms.single.common.constants.RedisKeyConstant;
import com.cpms.single.modules.auth.authen.IAuthen;
import com.cpms.single.modules.auth.authen.UserAuthenBuilder;
import com.cpms.single.modules.auth.dto.UserLoginDTO;
import com.wf.captcha.SpecCaptcha;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;


/**
 * @description: 授权认证接口
 * @author: gulang
 * @time: 2021/5/24 16:36
 */
@RestController
@RequestMapping("/auth")
public class AuthController {
    @PostMapping("/token")
    public Result<AuthInfo> token(@Validated @RequestBody UserLoginDTO userLoginDTO) {
        IAuthen authenType = UserAuthenBuilder.getGrantType(userLoginDTO.getGrantType());
        AuthInfo authInfo = authenType.authentication(userLoginDTO);
        return ResultUtil.success(authInfo);
    }

    /**
     * 获取验证码
     * @return
     */
    @GetMapping("/captcha")
    public Result<Object> captcha() {
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 5);
        String verCode = specCaptcha.text().toLowerCase();
        String key = UUID.randomUUID().toString().replaceAll("-","");
        // 存入redis并设置过期时间为60秒
        CsRedisUtil.set(String.format(RedisKeyConstant.UserLogin.CAPTCHA_KEY, key), verCode, 60, TimeUnit.SECONDS);
        // 将key和base64返回给前端
        Map<String, String> map = new HashMap(2);
        map.put("code", verCode);
        map.put("codeKey", key);
        map.put("image", specCaptcha.toBase64());
        return ResultUtil.success(map);
    }
}
