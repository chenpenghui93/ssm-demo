package com.example.toolkit.demo;

import com.example.HelloWorldService;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author cph
 * @Date 2020/3/25
 */
public class Test {
    public static void main(String[] args) {
        HelloWorldService service = new HelloWorldService();
        service.hello();
    }

    private static void replaceTest() {
        Map map = new HashMap<>();
        map.put("mobile", "[123456789]");
        String str = map.get("mobile").toString().replace("[", "").replace("]", "");
        System.out.println(str);
    }
}
