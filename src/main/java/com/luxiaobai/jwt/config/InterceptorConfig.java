package com.luxiaobai.jwt.config;

import com.luxiaobai.jwt.interceptors.JWTInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ：luxiaobai
 * @date ：Created in 2021/11/28 17:11
 * @description：
 * @modified By：`
 * @version: 1.0
 */
@Component
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTInterceptor())
                .addPathPatterns("/user/test")
                .excludePathPatterns("/user/login");
    }
}
