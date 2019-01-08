package com.example.ssmdemo;

import javax.servlet.*;
import java.io.IOException;

/**
 *
 *
 * @author cph
 * @version 1.0.0
 * @date 2019/1/8
 */
public class WebFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init···");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("before doFilter···");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("after doFilter···");
    }

    @Override
    public void destroy() {
        System.out.println("destory ···");
    }
}
