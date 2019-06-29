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
public class TestNewDate3 {
    public static void main(String[] args) {

        // "d/MM/yyyy" 可转换 "16/08/2016"、"6/08/2016"
        // "dd/MM/yyyy" 仅可转换 "06/08/2016"
        // 实际中推荐使用 "d/MM/yyyy"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

        String date = "16/08/2016";

        LocalDate localDate = LocalDate.parse(date, formatter);

        System.out.println(localDate);

        System.out.println(formatter.format(localDate));
    }
}
