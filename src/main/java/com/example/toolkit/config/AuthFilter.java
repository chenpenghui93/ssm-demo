package com.example.toolkit.config;

import javax.servlet.*;
import javax.servlet.FilterConfig;
import java.io.IOException;

/**
 *通过实现Filter接口自定义过滤器
 *
 * @author cph
 * @version 1.0.0
 * @date 2019/1/8
 */
public class AuthFilter implements Filter{

    /**
     *请求进入容器之后，未进入Servlet之前进行预处理
     *
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("AuthFilter.init()");
    }

    /**
     *
     *
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("before AuthFilter.doFilter()");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("after AuthFilter.doFilter()");
    }

    /**
     *
     *
     */
    @Override
    public void destroy() {
        System.out.println("AuthFilter.destory()");
    }
}
