package com.example.toolkit.demo;

import com.example.HelloWorldService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author cph
 * @Date 2020/3/25
 */
public class Test {
    public static void main(String[] args) {

        collectionOperationTest();

    }

    private static void collectionOperationTest() {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        set1.add("a");
        set1.add("b");
        set1.add("c");
        set2.add("b");
        set2.add("c");
        set2.add("d");

        // [a]
        set1.removeAll(set2);
        System.out.println("set1.removeAll(set2): " + set1);

        // []
        set1.retainAll(set2);
        System.out.println("set1.retainAll(set2): " + set1);

        // [b]
        set1.add("b");
        set1.retainAll(set2);
        System.out.println("set1.retainAll(set2): " + set1);

        // [b, c, d]
        set1.addAll(set2);
        System.out.println("set1.addAll(set2): " + set1);
    }

    private static void myFirstStarterTest() {
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
