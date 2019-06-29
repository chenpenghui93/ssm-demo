package com.example.ssmdemo.helloworld.string2localdate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Java 8 – How to convert String to LocalDate
 * https://www.mkyong.com/java8/java-8-how-to-convert-string-to-localdate/
 * String -> ZonedDateTime -> LocalDate
 *
 * @author cph
 * @date 2019/6/29
 */
public class TestNewDate7 {
    public static void main(String[] args) {

        String date = "2016-08-16T10:15:30+08:00";

        ZonedDateTime result = ZonedDateTime.parse(date, DateTimeFormatter.ISO_DATE_TIME);

        System.out.println("ZonedDateTime: " + result);

        System.out.println("TimeZone: " + result.getZone());

        LocalDate localDate = result.toLocalDate();

        System.out.println("LocalDate: " + localDate);
    }
}
