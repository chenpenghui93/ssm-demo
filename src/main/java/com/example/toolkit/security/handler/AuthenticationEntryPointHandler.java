package com.example.toolkit.security.handler;

import com.example.toolkit.core.Result;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 未登录处理类
 *
 * @author chenpenghui
 * @date 2021-1-22
 */
@Component
public class AuthenticationEntryPointHandler implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) {
        Result.json(response, Result.error(401, "未登录"));
    }
}
