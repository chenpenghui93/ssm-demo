package com.example.ssmdemo.helloworld.string2localdate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

/**
 * Java 8 – How to convert String to LocalDate
 * https://www.mkyong.com/java8/java-8-how-to-convert-string-to-localdate/
 *
 * String -> java.time.LocalDateTime
 *
 * @author cph
 * @date 2019/6/29
 */
public class TestNewDate5 {
    public static void main(String[] args) {

        // 存在时区问题
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, M d,  yyyy HH:mm:ss a");

        String date = "Tuesday, 8 16, 2016 12:10:56 PM";

        LocalDateTime localDateTime = LocalDateTime.parse(date, formatter);

        System.out.println(localDateTime);

        System.out.println(formatter.format(localDateTime));
    }
}
