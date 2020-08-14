package com.example.toolkit.sample;

import com.example.HelloWorldService;
import com.example.toolkit.common.RandomUtil;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author cph
 * @Date 2020/3/25
 */
public class Test {
    public static void main(String[] args) {
    }

    private static void regExIP() {
        String ip = "127.0.0.1,192.168.3.4,172.16.95.48,10.19.49.124";
        String regEx = "((2[0-4]\\d|25[0-5]|[01]?\\d\\d?)\\.){3}(2[0-4]\\d|25[0-5]|[01]?\\d\\d?)";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(ip);
        while (matcher.find()) {
            String result = matcher.group();
            System.out.println(result);
            break;
        }
    }

    private static void testJoin() {
        String s = String.join("--", "java", "is", "magic").concat("!!");
        System.out.println(s);
    }

    private static void testReg() {
        String str1 = "2019-01-01 00:00:00";
        String str2 = "2020-01-01 00:00:00";
        String str3 = "2021-01-01 00:00:00";
        System.out.println(str1.replaceAll("\\:|00|\\.0| ","").replace("-",""));
        System.out.println(str2.replaceAll("\\:|00|\\.0| ","").replace("-",""));
        System.out.println(str3.replaceAll("\\:|00|\\.0| ","").replace("-",""));
    }

    private static void testIntegerRange() {
        Integer i1 = -128;
        Integer i2 = 100;
        Integer i3 = 127;

        Integer i4 = 128;
        Integer i5 = -129;

        Integer integer1 = -128;
        Integer integer2 = 100;
        Integer integer3 = 127;

        Integer integer4 = 128;
        Integer integer5 = -129;

        // true
        System.out.println(i1 == integer1);
        // true
        System.out.println(i1.equals(integer1));
        // true
        System.out.println(i2 == integer2);
        // true
        System.out.println(i2.equals(integer2));
        // true
        System.out.println(i3 == integer3);
        // true
        System.out.println(i3.equals(integer3));
        // fasle
        System.out.println(i4 == integer4);
        // true
        System.out.println(i4.equals(integer4));
        // false
        System.out.println(i5 == integer5);
        // true
        System.out.println(i5.equals(integer5));
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
        String result = str.substring(begin + 1, end);
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
