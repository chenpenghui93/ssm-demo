package com.example.ssmdemo.helloworld.string2localdate;

import java.time.LocalDate;

/**
 * Java 8 – How to convert String to LocalDate
 * https://www.mkyong.com/java8/java-8-how-to-convert-string-to-localdate/
 *
 * @author cph
 * @date 2019/6/29
 */
public class TestNewDate1 {
    public static void main(String[] args) {
        String date = "2019-06-29";

        ////default, ISO_LOCAL_DATE
        LocalDate localDate = LocalDate.parse(date);

        System.out.println(localDate);
    }
}
