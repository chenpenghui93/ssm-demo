package com.example.ssmdemo.helloworld;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * https://my.oschina.net/mcyy568/blog/809608
 *
 * @author cph
 * @date 2019/5/28
 */
public class LocalDateTest {

    public static void main(String[] args) {

        localDateTest();
        localDate2Date();

    }

    private static void localDateTest() {
        System.out.println("当天："+ LocalDate.now());
        System.out.println("是否在当天之前："+ LocalDate.now().minusDays(1).isBefore(LocalDate.now()));
        System.out.println("是否在当天之后："+ LocalDate.now().plusDays(1).isAfter(LocalDate.now()));
        System.out.println("是否在当天："+ LocalDate.now().isEqual(LocalDate.now()));
        System.out.println("今年是否是闰年："+ LocalDate.now().isLeapYear());

        LocalDate date = LocalDate.of(2019, 5, 30);
        if (LocalDate.now().plusDays(1).toString().equals(date.toString())) {
            System.out.println(11111);
            System.out.println(LocalDate.now().plusDays(1));
        } else if (LocalDate.now().plusDays(2).toString().equals(date.toString())) {
            System.out.println(2222222);
            System.out.println(LocalDate.now().plusDays(2));
        }
    }

    private static void localDate2Date() {
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDate localDate = LocalDate.now();
        ZonedDateTime zdt = localDate.atStartOfDay(zoneId);

        Date date = Date.from(zdt.toInstant());

        System.out.println(localDate);
        System.out.println(zdt);
        System.out.println(date);
    }
}