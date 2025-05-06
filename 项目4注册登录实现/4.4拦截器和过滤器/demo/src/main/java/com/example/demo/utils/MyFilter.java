package com.example.demo.utils;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
public class MyFilter implements Filter {
    //    配置白名单
    private final List<String> whiteList = Arrays.asList("/api/login", "/api/logout","/api/testFilter");

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("========init========");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("========doFilter========");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String requestURI = request.getRequestURI();
        if (whiteList.contains(requestURI)) {
            filterChain.doFilter(servletRequest, servletResponse);
            System.out.println("========走白名单后过滤器放行========");
        } else {
            HttpSession session = request.getSession();
            if (StringUtils.isEmpty(session.getAttribute("userName"))) {
                System.out.println("========走过滤器登录========");
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
                System.out.println("========登录成功后过滤器放行========");
            }
        }
    }

    @Override
    public void destroy() {
        System.out.println("========destroy========");
    }
}
