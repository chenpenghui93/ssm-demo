package com.example.helloworld;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cph
 * @version 1.0
 * @date 2019/1/6
 */
public class UsualTest {
    public static void main(String[] args) {
        String str = "0123456";
        //1
        int i = str.indexOf("1");
        //4
        int j = str.lastIndexOf("45");
        System.out.println();
    }

    public static void testNull(){
        Map m = new HashMap();
        m.put("key", null);
        for (Object key : m.keySet()) {
            System.out.println(key + " " + m.get(key));
        }

    }

    public static void doubleTest(){
        double d1 = 4.87;
        double d2 = 1.7845;
        double d3 = d1 + d2;

        DecimalFormat df = new DecimalFormat("0.0000");
        df.setRoundingMode(RoundingMode.HALF_UP);
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(df.format(d3));
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

    static void subStringTest(){

        String date = "2018/04/11";

        //起始位置(包含起始)
        System.out.println(date.substring(1));

        //截取开始、结束（不包含结束）
        System.out.println(date.substring(0, 4));

    }

    public enum  Status{
        A,
        B,
        C,
    }
}
