package com.example.toolkit.config;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 设计思想：过滤器是servlet开发中的概念，用于对处理器进行预处理、后处理
 * 适用场景：切面应用，如用户登录、日志记录等
 * 使用方法：实现javax.servlet.Filter接口，配置FilterRegistrationBean
 *
 * @author cph
 * @version 1.0.0
 * @date 2019/1/8
 */
public class AuthFilter implements Filter {

    /**
     * init
     * 请求进入容器之后，未进入Servlet之前进行预处理
     *
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("AuthFilter.init()===========================");
    }

    /**
     * doFilter
     *
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        System.out.println("URI: " + request.getRequestURI());
        System.out.println("URL: " + request.getRequestURL().toString());
        System.out.println("before AuthFilter.doFilter()===============");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("after AuthFilter.doFilter()================");
    }

    /**
     * destroy
     */
    @Override
    public void destroy() {
        System.out.println("AuthFilter.destory()==========");
    }
}
