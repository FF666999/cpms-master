package com.cpms.single.config;

import com.cpms.single.core.interceptor.ReqHandlerInterceptor;
import com.cpms.single.core.props.AuthUrlProperties;
import com.cpms.single.core.props.DefaultUrlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * @author gulang
 * @Description: web拦截器配置
 * @date 2021/2/16 14:04
 */
@Configuration
public class ReqWebMvcConfig implements WebMvcConfigurer {
    @Autowired
    private AuthUrlProperties authUrlProperties;
    /**
     *  将拦截器配置到容器中
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        DefaultUrlProperties.getDefaultSkipUrl().addAll(authUrlProperties.getSkipUrl());
        registry.addInterceptor(new ReqHandlerInterceptor())
                //所有路径都被拦截
                .addPathPatterns("/**")
                // 不需要拦截的url
                .excludePathPatterns(DefaultUrlProperties.getDefaultSkipUrl());
    }

}

