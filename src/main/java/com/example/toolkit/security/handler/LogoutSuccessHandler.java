package com.example.toolkit.security.handler;


import com.example.toolkit.core.Result;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 登出成功处理类
 *
 * @author chenpenghui
 * @date 2021-1-24
 */
public class LogoutSuccessHandler implements org.springframework.security.web.authentication.logout.LogoutSuccessHandler {

    /**
     * 返回登出结果，前端同步清除token
     *
     * @param request
     * @param response
     * @param authentication
     */
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", "200");
        result.put("msg", "登出成功");
        SecurityContextHolder.clearContext();
        Result.json(response, Result.ok(result));
    }
}
