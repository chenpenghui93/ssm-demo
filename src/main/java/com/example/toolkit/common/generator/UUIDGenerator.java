package com.example.toolkit.common.generator;

import java.util.UUID;

/**
 * UUIDGenerator
 *
 * @author chenpenghui
 * @date 2020/4/22
 */
public class UUIDGenerator {

    public static void main(String[] args) {
        String s = generateUUID();
        System.out.println(s);
        s = s.replace("-", "");
        System.out.println(s);
    }

    public static String generateUUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }
}
