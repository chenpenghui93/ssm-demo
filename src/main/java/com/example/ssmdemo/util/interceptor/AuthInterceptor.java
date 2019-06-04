package com.example.ssmdemo.util.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 通过实现接口HandlerInterceptor自定义拦截器
 *
 * @author cph
 * @version 1.0.0
 * @date 2019/1/8
 */
@Configuration
public class AuthInterceptor implements HandlerInterceptor {

    /**
     * 请求被处理之前调用
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("AuthInterceptor.preHandle()");
        return true;
    }

    /**
     * 请求被处理，视图渲染之前调用（controller调用之后）
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("AuthInterceptor.postHandle()");

    }

    /**
     * 请求结束之后调用
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("AuthInterceptor.afterCompletion()");

    }
}
