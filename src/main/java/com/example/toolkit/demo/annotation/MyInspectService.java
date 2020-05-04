package com.example.toolkit.demo.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author chenpenghui
 * @date 2020/5/4
 */
@Component
@Aspect
public class MyInspectService {

    @Pointcut("@annotation(com.example.toolkit.demo.annotation.MyAnnotation)")
    public void queryMethodPointcut() {
    }

    @Around("queryMethodPointcut()&&@annotation(firstAnnotation)")
    public Object doProcess(ProceedingJoinPoint joinPoint, MyAnnotation firstAnnotation) throws Throwable {
        String name = firstAnnotation.name();
        System.out.println("===MyInspectService.doProcess()=== " + name);
        return joinPoint.proceed();
    }
}
