package com.cpms.single.core.interceptor;

import com.alibaba.fastjson.JSON;
import com.cpms.framework.common.constants.CoreCommonConstant;
import com.cpms.framework.common.enums.GlobalResponseResultEnum;
import com.cpms.framework.common.exception.BizException;
import com.cpms.framework.common.exception.CheckJwtException;
import com.cpms.framework.common.utils.CsJwtUtil;
import io.jsonwebtoken.Claims;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;


/**
 * @author gulang
 * @Description: 请求拦截器
 * @date 2021/2/1614:06
 */
public class ReqHandlerInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(ReqHandlerInterceptor.class);
    /**
     * 在请求处理之前进行调用（Controller方法调用之前,Filter过滤器之后）
     * @return  1.如果设置为true时，请求将会继续执行后面的操作 2.如果设置为false时，被请求时，拦截器执行到此处将不会继续操作
     */
    @SneakyThrows
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String headerToken = request.getHeader(CoreCommonConstant.H_TOKEN_KEY);
        String paramToken = request.getParameter(CoreCommonConstant.H_TOKEN_KEY);
        if (StringUtils.isAllBlank(headerToken, paramToken)) {
         throw new BizException(GlobalResponseResultEnum.LOSE_AUTH_TOKEN_ERROR.getCode(),GlobalResponseResultEnum.LOSE_AUTH_TOKEN_ERROR.getMessage());
        }
        String token = StringUtils.isBlank(headerToken) ? paramToken : headerToken;
        Claims claims;
        try{
            claims = CsJwtUtil.parseJwt(token);
        }catch (CheckJwtException e){
            throw new BizException(e.getCode(),e.getMessage());
        }
        claims.put("tokenExpire",claims.get("exp"));
        request.setAttribute(CoreCommonConstant.USER_INFO,URLEncoder.encode(JSON.toJSONString(claims), "UTF-8"));
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex){

    }
}
