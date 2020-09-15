package com.example.toolkit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 重定向测试
 *
 * @author chenpenghui
 * @date 2020-9-15
 */
//@RestController
@Controller
@RequestMapping("/test")
public class RedirectTestController {

    /**
     * HttpServletResponse.sendRedirect()
     *
     * @throws IOException
     */
    @RequestMapping("/redirect")
    public void testRedirect() throws IOException {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = servletRequestAttributes.getResponse();
        response.sendRedirect("http://www.baidu.com");
    }

    /**
     * "redirect:http://www.baidu.com"
     * 注意：@RestController相当于类中的所有方法都标注了@ResponseBody，这些方法会返回json对象
     * 这种情况下控制器需要使用@Controller注解
     *
     * @return
     */
    @RequestMapping("/redirect1")
    public String testRedirect1() {
        return "redirect:http://www.baidu.com";
    }
}
