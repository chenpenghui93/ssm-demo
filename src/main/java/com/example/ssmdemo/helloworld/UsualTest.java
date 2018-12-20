package com.example.ssmdemo.helloworld;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author cph
 * @version 1.0.0
 * @date 2018/12/18
 */
public class UsualTest {

    public static void main(String[] args) {

        mapTest();

    }

    private static void mapTest() {

        Map map = new HashMap(16);
        map.put("issues_name", "辨识及吸引高端顾客");
        map.put("categories_name", "顾客洞察");

        System.out.println(map.get("categories_name").toString());

        Set<String> strat = new HashSet<>();
        strat.add(map.get("issues_name").toString());
        strat.add(map.get("categories_name").toString());

        System.out.println(strat);
    }


}
