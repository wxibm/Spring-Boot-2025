package com.example.demo.utils;

import com.example.demo.mapper.UserRoleModuleMapper;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
public class MyFilter implements Filter {
//    配置白名单
    private final List<String> whiteList = Arrays.asList("/api/login", "/api/logout", "/api/register");
    private UserRoleModuleMapper userRoleModuleMapper;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("========过滤器init========");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("========do过滤器========");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        UserAuthority userAuthority = new UserAuthority();
        String requestURI = request.getRequestURI();
        if (whiteList.contains(requestURI)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
//            在这里判断用户是否具有访问权限
            if (userAuthority.check("USER002", requestURI))
                filterChain.doFilter(servletRequest, servletResponse);
            else
                System.out.println("========您没有权限========");
        }
    }

    @Override
    public void destroy() {
        System.out.println("========过滤器destroy========");
    }
}
