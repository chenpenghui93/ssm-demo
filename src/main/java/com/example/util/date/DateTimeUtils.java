package com.example.util.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author cph
 * @date 2019/6/28
 */
public class DateTimeUtils {
    public static void main(String[] args) {
//        string2LocalDate();
//        localDateTest();
//        localDate2Date();
        unixTimeTest();

    }

    private static void unixTimeTest() {

        long t = System.currentTimeMillis();
        System.out.println("long time " + t);

        // 当前时区
        SimpleDateFormat sdf_default = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("current " + sdf_default.format(t));

        // +8:00
        SimpleDateFormat sdf_8 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf_8.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        System.out.println("GMT+8:00 " + sdf_8.format(t));

        // +7:00
        SimpleDateFormat sdf_7 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf_7.setTimeZone(TimeZone.getTimeZone("GMT+7:00"));
        System.out.println("GMT+7:00 " + sdf_7.format(t));

        // -9:00
        SimpleDateFormat sdf_la = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf_la.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
        System.out.println("America/Los_Angeles " + sdf_la.format(t));

    }

    private static void localDateTest() {
        System.out.println("当天：" + LocalDate.now());
        System.out.println("是否在当天之前：" + LocalDate.now().minusDays(1).isBefore(LocalDate.now()));
        System.out.println("是否在当天之后：" + LocalDate.now().plusDays(1).isAfter(LocalDate.now()));
        System.out.println("是否在当天：" + LocalDate.now().isEqual(LocalDate.now()));
        System.out.println("今年是否是闰年：" + LocalDate.now().isLeapYear());

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

    private static void string2LocalDate() {
        //Java 8 – How to convert String to LocalDate
        //https://www.mkyong.com/java8/java-8-how-to-convert-string-to-localdate/

        //default, ISO_LOCAL_DATE
        String date1 = "2019-06-29";
        LocalDate localDate1 = LocalDate.parse(date1);
        System.out.println("localDate1: " + localDate1);

        // DateTimeFormatter.ofPattern()中JVM会自动获取出当前的时区，并按照此时区进行字符串对比
        // 示例日期字符串需要根据所在时区进行构造, Aug是英系时区的字符
        // 否则会出现 Exception in thread "main" java.time.format.DateTimeParseException: Text '16-Aug-2016' could not be parsed at index 3
        // 原因是底层代码会将 Aug 与 8 比较？
        String date2 = "29-6-2018";
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("d-M-yyyy");
        LocalDate localDate2 = LocalDate.parse(date2, formatter2);
        System.out.println("localDate2: " + localDate2);
        System.out.println("formatter2.format(): " + formatter2.format(localDate2));

        // "d/M/yyyy" 可转换 "16/08/2016"、"6/10/2016"
        // "dd/MM/yyyy" 仅可转换 "06/08/2016"
        // 实际中推荐使用 "d/M/yyyy"
        String date3 = "16/08/2016";
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate localDate3 = LocalDate.parse(date3, formatter3);
        System.out.println("localDate3: " + localDate3);
        System.out.println("formatter3.format(): " + formatter3.format(localDate3));

        //The ‘Z’ suffix means UTC, you can convert into a java.time.instant directly, then display it with a time zone.
        String date4 = "2016-08-16T15:23:01Z";
        Instant instant = Instant.parse(date4);
        System.out.println("Instant: " + instant);
        //datetime time
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.of(ZoneOffset.UTC.getId()));
        //localdate
        System.out.println("localDateTime: " + localDateTime.toLocalDate());
        //datetime time + timezone
        ZonedDateTime zonedDateTime1 = instant.atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println("zonedDateTime1: " + zonedDateTime1);
        ZonedDateTime zonedDateTime2 = instant.atZone(ZoneId.of("Europe/Athens"));
        System.out.println("zonedDateTime2: " + zonedDateTime2);

        //String -> ZonedDateTime -> LocalDate
        String date5 = "2016-08-16T10:15:30+08:00";
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(date5, DateTimeFormatter.ISO_DATE_TIME);
        System.out.println("ZonedDateTime: " + zonedDateTime);
        System.out.println("TimeZone: " + zonedDateTime.getZone());
        LocalDate localDate5 = zonedDateTime.toLocalDate();
        System.out.println("LocalDate5: " + localDate5);


        //How to convert String to Date – Java
        //https://www.mkyong.com/java/how-to-convert-string-to-date-java/

        String dateString6 = "2016-6-29";
        SimpleDateFormat formatter6 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date6 = formatter6.parse(dateString6);
            System.out.println("date6: " + date6);
            System.out.println("formatter6.format(): " + formatter6.format(date6));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("LocalDate.now(): " + LocalDate.now());
    }

}
