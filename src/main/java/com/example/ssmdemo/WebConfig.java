package com.example.ssmdemo;

import com.example.ssmdemo.hello.SpringMVCInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 通过实现接口WebMvcConfigurer添加拦截器
 *
 * @author cph
 * @version 1.0.0
 * @date 2019/1/8
 */
@Component
public class WebConfig implements WebMvcConfigurer {

    /**
     * 实例化自定义拦截器类
     *
     * @return
     */
    SpringMVCInterceptor springMVCInterceptor(){
        return new SpringMVCInterceptor();
    }

    /**
     * 添加拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(springMVCInterceptor());
    }


}
