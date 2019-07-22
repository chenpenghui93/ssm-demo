package com.example.ssmdemo.helloworld.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author cph
 * @date 2019/7/22
 */
public class Apple {

    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static void main(String[] args) throws Exception {

        //正常调用
        Apple apple = new Apple();
        apple.setPrice(10);
        System.out.println("正常调用：price=" + apple.getPrice());

        //反射调用
        //1.获取类的Class对象实例
        Class clazz = Class.forName("com.example.ssmdemo.helloworld.reflection.Apple");
        //2.利用Class对象实例获取Constructor对象实例
        Constructor appleConstructor = clazz.getConstructor();
        //3.利用Constructor对象实例的newInstance()方法获取目标类实例
        Object appleObject = appleConstructor.newInstance();
        //4.利用Class对象实例获取Method对象实例
        Method setPriceMethod = clazz.getMethod("setPrice", int.class);
        //5.利用invoke()调用方法
        setPriceMethod.invoke(appleObject, 20);
        Method getPriceMethod = clazz.getMethod("getPrice");
        System.out.println("反射调用：price=" + getPriceMethod.invoke(appleObject));
    }
}
