package com.example.ssmdemo.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author cph
 * @version 1.0.0
 * @date 2018/12/18
 */
public class TestMethod {

    public static void main(String[] args) {

        MapTest();

    }

    private static void MapTest(){

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
