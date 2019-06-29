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
public class TestNewDate4 {
    public static void main(String[] args) {

        // 存在时区问题
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, MMM d yyyy");

        String date = "Tue, Aug 16 2016";

        LocalDate localDate = LocalDate.parse(date, formatter);

        System.out.println(localDate);

        System.out.println(formatter.format(localDate));
    }
}
