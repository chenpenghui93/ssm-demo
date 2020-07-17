//package com.example.toolkit.demo.annotation;
//
//import org.elasticsearch.common.inject.Inject;
//import org.springframework.beans.BeansException;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContextAware;
//import org.springframework.core.annotation.AnnotationUtils;
//import org.springframework.core.env.Environment;
//import org.springframework.stereotype.Component;
//import org.springframework.util.ReflectionUtils;
//
//import javax.annotation.PostConstruct;
//import java.lang.reflect.Method;
//import java.util.Objects;
//
///**
// * @author chenpenghui
// * @date 2020/5/4
// */
//@Component
//public class MyApplicationContextAware implements ApplicationContextAware {
//
//    protected ApplicationContext applicationContext;
//
//    private String MESSAGE = "helloworld.message";
//
//    @Inject
//    private Environment env;
//
//    public MyApplicationContextAware(Environment env) {
//        this.env = env;
//    }
//
//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        this.applicationContext = applicationContext;
//    }
//
//    @PostConstruct
//    public void init() {
//        String[] beanNames = applicationContext.getBeanDefinitionNames();
//        for (String beanName : beanNames) {
//            Object bean = applicationContext.getBean(beanName);
//            Method[] methods = ReflectionUtils.getUniqueDeclaredMethods(bean.getClass());
//            if (Objects.nonNull(methods)) {
//                for (Method method : methods) {
//                    MyAnnotation myAnnotation = AnnotationUtils.findAnnotation(method, MyAnnotation.class);
//                    if (Objects.nonNull(myAnnotation)) {
//                        String name = myAnnotation.name();
//                        System.out.println("===MyApplicationContextAware.init()=== " + name);
//                        System.out.println(env.getProperty(MESSAGE));
//                    }
//                }
//            }
//        }
//
//    }
//}
