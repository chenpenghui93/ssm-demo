package com.example.toolkit.hello.set;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cph
 * @date 2019/12/11
 */
public class MapTest {

    public static void main(String[] args) {
        Map<String, Employee> staff = new HashMap<>();
        staff.put("zhangsan", new Employee(1L, "zhangsan", "111111"));
        staff.put("lisi", new Employee(2L, "lisi", "22222"));
        staff.put("wangwu", new Employee(3L, "wangwu", "333333"));

        System.out.println(staff);

        staff.remove("zhangsan");
        System.out.println(staff);

        staff.put("liuliu", new Employee(4L, "liuliu", "44444"));

        System.out.println(staff.get("wangwu"));

        for (Map.Entry<String, Employee> entry : staff.entrySet()) {
            String key = entry.getKey();
            Employee value = entry.getValue();
            System.out.println("key: " + key + ", value: " + value);
        }

        System.out.println(staff.keySet());
        System.out.println(staff.values());

    }
}
