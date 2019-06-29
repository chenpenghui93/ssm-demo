package com.example.ssmdemo.helloworld.string2localdate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Java 8 – How to convert String to LocalDate
 * https://www.mkyong.com/java8/java-8-how-to-convert-string-to-localdate/
 *
 * @author cph
 * @date 2019/6/29
 */
public class TestNewDate2 {
    public static void main(String[] args) {

        // 第一步中JVM会自动加载出当前的时区，并按照此时区进行字符串对比
        // 示例日期字符串需要根据所在时区进行构造, Aug是英系时区的字符
        // 否则会出现 Exception in thread "main" java.time.format.DateTimeParseException: Text '16-Aug-2016' could not be parsed at index 3
        // 原因是底层代码会将 Aug 与 8 比较？

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-yyyy");

        String date = "16-8-2016";

        LocalDate localDate = LocalDate.parse(date, formatter);

        System.out.println(localDate);

        System.out.println(formatter.format(localDate));

    }
}
