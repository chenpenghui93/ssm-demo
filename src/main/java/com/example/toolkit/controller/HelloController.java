package com.example.toolkit.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author chenpenghui
 * @date 2020-9-7
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Value("${helloworld.message}")
    private String message;

    @GetMapping("/hi")
    public String hi(){
        return message;
    }

    @GetMapping("/world")
    public String hello() {
        return "{\"hello\":\"world\"}";
    }

    @PostMapping("/world/{name}")
    public String hello(@PathVariable String name) {
        return "hello, " + name;
    }
}
