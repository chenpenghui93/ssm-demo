package com.example.ssmdemo.helloworld;

import java.util.*;

/**
 * @author cph
 * @version 1.0.0
 * @date 2018/12/18
 */
public class UsualTest {

    public static void main(String[] args) {

        //mapTest();
        arrayTest();

    }

    public static void mapTest() {

        Map map = new HashMap(16);
        map.put("issues_name", "辨识及吸引高端顾客");
        map.put("categories_name", "顾客洞察");

        System.out.println(map.get("categories_name").toString());

        Set<String> strat = new HashSet<>();
        strat.add(map.get("issues_name").toString());
        strat.add(map.get("categories_name").toString());

        System.out.println(strat);
    }

    public static void arrayTest() {
        ArrayList arrayList = new ArrayList();
        Map map1 = new HashMap();
        map1.put("a","1");
        map1.put("b","2");
        Map map2 = new HashMap();
        map2.put("c","3");
        arrayList.add(map1);
        arrayList.add(map2);

        System.out.println(arrayList);
        System.out.println(arrayList.toArray());
    }


}
