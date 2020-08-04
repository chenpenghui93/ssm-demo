package com.example.toolkit.sample;

import com.example.HelloWorldService;

import java.util.*;

/**
 * @Author cph
 * @Date 2020/3/25
 */
public class Test {
    public static void main(String[] args) {
        testStreamDebugger();
    }

    private static void testStreamDebugger() {
        structureTest();
        streamTest();
    }

    private static void streamTest() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.stream()
                .filter(item -> item > 3)
                .forEach(System.out::println);
    }

    private static void structureTest() {
        List<Map<String, List<String>>> result = new ArrayList<>();
        List<String> list1 = Arrays.asList("1", "22", "33");
        Map map1 = new HashMap();
        map1.put("menu", list1);
        result.add(map1);
        System.out.println(result);
    }

    private static void String2Integer() {
        String s = "1";
//        Integer integer = Integer.parseInt(s, Integer.MAX_VALUE);
        Integer integer = Integer.parseInt(s);
        System.out.println(integer);
    }

    private static void substringtest() {
        String str = "basic-mqMessages-query";
        //返回起始位置，下标从0开始
        int begin = str.indexOf("-");
        int end = str.lastIndexOf("-");
        String result =str.substring(begin+1, end);
        System.out.println(result);
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
