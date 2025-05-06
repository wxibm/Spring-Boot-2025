package com.example.demo.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("========走拦截器白名单========");
//        addPathPatterns("/**")对所有请求都拦截，/**代表所有路径，/*代表一级路径
//        excludePathPatterns：用于设置不需要拦截的过滤规则
        registry.addInterceptor(new MyInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/api/login", "/api/logout","/api/testInterceptors");
        ///api/login和/api/logout不要走拦截器
    }
}
