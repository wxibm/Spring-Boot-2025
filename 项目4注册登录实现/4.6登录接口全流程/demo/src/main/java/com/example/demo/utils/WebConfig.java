package com.example.demo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    MyInterceptor myInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        addPathPatterns("/**")对所有请求都拦截
//        excludePathPatterns：用于设置不需要拦截的过滤规则
        registry.addInterceptor(myInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/api/login", "/api/logout", "/api/register");
        ///api/login和/api/logout不要走拦截器
    }
}
