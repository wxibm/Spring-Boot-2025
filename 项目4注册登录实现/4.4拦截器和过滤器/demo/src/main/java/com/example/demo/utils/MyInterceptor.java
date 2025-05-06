package com.example.demo.utils;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class MyInterceptor implements HandlerInterceptor {
//    如果返回true，则继续调用下一个拦截器。
//    如果返回false，则中断执行，也就是说我们想调用的方法不会被执行，
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("========preHandle========");
        HttpSession session = request.getSession();
        if (StringUtils.isEmpty(session.getAttribute("userName"))) {
            System.out.println("========走拦截器登录========");
            return false;
        }
        return true; // 如果session存在，则继续执行
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("========postHandle========");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("========afterCompletion========");
    }
}
