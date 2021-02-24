package com.example.toolkit.sample.quartz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 反射执行方法
 *
 * @author chenpenghui
 * @date 2021-2-24
 */
@Component
public class TaskUtils {

    @Autowired
    private ConfigurableListableBeanFactory beanFactory;

    public void invokMethod(QuartzConfig config) {
        Object obj = null;
        Class clazz;
        try {
            String className = lowerCaseInit(config.getClassPath().split("\\.")[config.getClassPath().split("\\.").length - 1]);
            if (containsBean(className)) {
                // 先在Spring上下文中找
                obj = beanFactory.getBean(className);
            }
            if (obj == null) {
                clazz = Class.forName(config.getClassPath());
                obj = clazz.newInstance();
            } else {
                clazz = obj.getClass();
            }
        } catch (Exception e) {
            throw new RuntimeException("ERROR:TaskUtils is Bean Create please check the classpath is`t right or not");
        }
        Method method;
        // 获得方法名
        try {
            method = clazz.getDeclaredMethod(config.getMethodName());
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("ERROR:TaskUtils is Bean the method Create please check the methodName is`t right or not");
        }
        // 执行方法
        try {
            method.invoke(obj);
        } catch (Exception e) {
            throw new RuntimeException("ERROR:TaskUtils is Bean the method execute please check the methodName is`t right or not");
        }

    }

    private static String lowerCaseInit(String str) {
        if (str.length() > 0) {
            char c = str.charAt(0);
            if (c >= 65 && c <= 90) {
                int i = c + 32;
                return ((char) i) + str.substring(1);
            } else {
                return str;
            }
        } else {
            return null;
        }
    }

    public boolean containsBean(String name) {
        return beanFactory.containsBean(name);
    }

}
