package com.example.ssmdemo.helloworld;

/**
 * @author cph
 * @version 1.0
 * @date 2019/1/6
 */
public class UsualTest {
    public static void main(String[] args) {
        //mathMethodTest();
        //startWithMethod();
        splitMethod();
    }

    public static void mathMethodTest() {
        final int COUNT = 20;
        for (int i = 0; i < COUNT; i++) {
            System.out.println(Math.random());
        }
    }

    public static void startWithMethod() {
        String string = "www.runoob.com";

        //true
        System.out.println(string.startsWith("www"));
        //false
        System.out.println(string.startsWith("runoob"));
        //true
        System.out.println(string.startsWith("runoob", 4));
    }

    static void splitMethod() {
        String s1 = "天地玄黄，宇宙洪荒";
        String s2 = "a|b|c|d";

        for (String st1 : s1.split("，")) {
            System.out.println(st1);
        }
        for (String st2 : s2.split("\\|")) {
            System.out.println(st2);
        }
        for (String st2 : s2.split("\\|", 3)) {
            System.out.println(st2);
        }
    }
}
