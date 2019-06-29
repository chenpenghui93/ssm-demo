package com.example.ssmdemo.helloworld.string2localdate;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * Java 8 – How to convert String to LocalDate
 * https://www.mkyong.com/java8/java-8-how-to-convert-string-to-localdate/
 * The ‘Z’ suffix means UTC, you can convert into a java.time.instant directly, then display it with a time zone.
 *
 * @author cph
 * @date 2019/6/29
 */
public class TestNewDate6 {
    public static void main(String[] args) {

        String dateString = "2016-08-16T15:23:01Z";

        Instant instant = Instant.parse(dateString);

        System.out.println("Instant: " + instant);

        //date time
        LocalDateTime result = LocalDateTime.ofInstant(instant, ZoneId.of(ZoneOffset.UTC.getId()));

        //localdate
        System.out.println("LocalDate: " + result.toLocalDate());

        //date time + timezone
        ZonedDateTime zonedDateTime1 = instant.atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println(zonedDateTime1);

        ZonedDateTime zonedDateTime2 = instant.atZone(ZoneId.of("Europe/Athens"));
        System.out.println(zonedDateTime2);

    }
}
