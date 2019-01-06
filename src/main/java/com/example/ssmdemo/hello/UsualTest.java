package com.example.ssmdemo.hello;

/**
 * @author cph
 * @version 1.0
 * @date 2019/1/6
 */
public class UsualTest {
    public static void main(String[] args) {
        mathMethodTest();
    }

    public static void mathMethodTest() {
        final int COUNT = 20;
        for (int i = 0; i < COUNT; i++) {
            System.out.println(Math.random());
        }
    }
}
