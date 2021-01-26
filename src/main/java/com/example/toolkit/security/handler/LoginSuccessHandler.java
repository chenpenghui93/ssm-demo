package com.example.toolkit.security.handler;

import com.example.toolkit.config.JWTConfig;
import com.example.toolkit.core.Result;
import com.example.toolkit.security.entity.SelfUserEntity;
import com.example.toolkit.utils.JWTTokenUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录成功处理类
 *
 * @author chenpenghui
 * @date 2021-1-22
 */
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        SelfUserEntity selfUserEntity = (SelfUserEntity)authentication.getPrincipal();
        String token = JWTTokenUtil.createAccessToken(selfUserEntity);
        token = JWTConfig.tokenPrefix + token;
        Map<String, Object> result = new HashMap<>();
        result.put("code", "200");
        result.put("msg", "登录成功");
        result.put("token", token);
        Result.json(response, result);
    }
}
