package com.example.demo.utils;

import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 自定义拦截器
 */
@Component
public class MyInterceptor implements HandlerInterceptor {
    //    preHandle：在方法被调用前执行。
//    如果返回true，则继续调用下一个拦截器。
//    如果返回false，则中断执行，也就是说我们想调用的方法不会被执行，
//    但是你可以修改response为你想要的响应。
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("========preHandle========");
        String token = request.getHeader("token");
        if(StringUtils.isEmpty(token)){
            System.out.println("========走拦截器提示登录========");
            return false;
        }
        return true;
    }

    //    postHandle：在方法执行后调用。
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("========postHandle========");
    }

    //    afterCompletion：在整个请求处理完毕后进行回调，也就是说视图渲染完毕或者调用方已经拿到响应。
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("========afterCompletion========");
    }
}
