package com.example.toolkit.sample.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author chenpenghui
 * @date 2020-10-17
 */
@RestController
public class TestAsyncController {
    @Autowired
    TestAsyncService service;

    @Autowired
    TestAnnotationAsyncService annotationService;

    /**
     * 同步执行
     */
    @GetMapping("/test")
    public void test() {
        System.out.println("主线程名称: " + Thread.currentThread().getName());
        service.serviceTest();
        System.out.println("执行成功，返回结果");
    }

    /**
     * 手写线程池实现异步执行
     */
    @GetMapping("/test1")
    public void test1() {
        System.out.println("主线程名称: " + Thread.currentThread().getName());
        /**
         * CorePoolSize: 1
         * MaximumPoolSize: 5
         * KeepAliveTime: 50000
         */
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 5, 50000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        executor.execute(() -> service.serviceTest());
        System.out.println("执行成功，返回结果");
    }

    /**
     * 使用spring注解实现异步执行
     * 1、类上添加注解 @EnableAsync
     * 2、方法上添加注解 @Async
     * 3、业务方法注入类，直接调用方法
     */
    @GetMapping("/test2")
    public void test2() {
        System.out.println("主线程名称: " + Thread.currentThread().getName());
        annotationService.serviceTest();
        System.out.println("执行成功，返回结果");
    }

}
