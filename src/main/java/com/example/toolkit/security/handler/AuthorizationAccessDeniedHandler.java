package com.example.toolkit.security.handler;

import com.example.toolkit.core.Result;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 未授权处理类
 *
 * @author chenpenghui
 * @date 2021-1-22
 */
@Component
public class AuthorizationAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) {
        Result.json(response, Result.error(403, "未授权"));
    }
}
