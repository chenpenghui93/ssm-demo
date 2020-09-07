package com.example.toolkit.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author chenpenghui
 * @date 2020-9-7
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/world")
    public String hello() {
        return "hello world!";
    }

    @PostMapping("/world/{name}")
    public String hello(@PathVariable String name) {
        return "hello, " + name;
    }
}
