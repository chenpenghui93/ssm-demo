package com.example.ssmdemo.util.datetime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author cph
 * @date 2019/6/28
 */
public class DateTimeUtils {
    public static void main(String[] args) {

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

        System.out.println("LocalDate.now(): "+ LocalDate.now());
    }

}
