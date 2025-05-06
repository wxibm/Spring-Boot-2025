package com.example.demo.utils;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import io.micrometer.common.util.StringUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
//@WebFilter(urlPatterns="/*", filterName="MyFilter")
//urlPatterns：过滤器要拦截的URL模式，即"/"。这里的"/*"表示该过滤器将拦截应用程序中的所有URL请求。
public class MyFilter implements Filter {
    @Autowired
    private RedisClient redisClient;
//    配置白名单
    private final List<String> whiteList = Arrays.asList("/api/login", "/api/logout", "/api/register");

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("========过滤器init========");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("========do过滤器========");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String requestURI = request.getRequestURI();
        if (whiteList.contains(requestURI)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            String token = request.getHeader("token");
            System.out.println("token = " + token);
//            据前端传递的token，获取数据库中存储的用户ID，如果能获取到，则校验通过，否则提示用户token已过期，需要用户重新登录等等。
//            redisClient.get(token)如果token为空，会报错
            if (StringUtils.isNotEmpty(token)&&StringUtils.isNotEmpty(redisClient.get(token)))
                filterChain.doFilter(servletRequest, servletResponse);
            else
                System.out.println("========走过滤器提示登录========");
        }
    }

    @Override
    public void destroy() {
        System.out.println("========过滤器destroy========");
    }
}
