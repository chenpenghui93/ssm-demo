package com.example.toolkit.common.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * Java8 日期时间测试
 *
 * @Author cph
 * @Date 2020/1/12
 */
public class LocalDateTest {
    public static void main(String[] args) {
        localDateTest();
        localTimeTest();
        localDateTimeTest();
    }

    /**
     * LocalDate获取各种日期
     */
    public static void localDateTest() {
        System.out.println("========LocalDate========");
        LocalDate today = LocalDate.now();
        System.out.println("当前日期: " + today);
        System.out.println("当前日期的年: " + today.getYear());
        System.out.println("当前日期的月-枚举类型: " + today.getMonth());
        System.out.println("当前日期的月-数字类型: " + today.getMonthValue());
        System.out.println("当前日期是一个月中的第几天: " + today.getDayOfMonth());
        System.out.println("当前日期是一个周中的第几天: " + today.getDayOfWeek());
        System.out.println("当前日期是一年中的第几天: " + today.getDayOfYear());
        System.out.println("年表: " + today.getChronology());

        LocalDate localDate1 = LocalDate.of(2019, 12, 31);
        System.out.println("lastDay: " + localDate1);
        //需严格遵循ISO的yyyy-MM-dd格式
        LocalDate localDate2 = LocalDate.parse("2019-12-31");
        System.out.println("localDate2: " + localDate2);

        LocalDate firstDayOfMonth = today.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println("当前日期所在月的第一天: " + firstDayOfMonth);
        LocalDate lastDayOfMonth = today.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("当前日期所在月的最后一天: " + lastDayOfMonth);
        LocalDate SecondDayOfMonth = today.withDayOfMonth(2);
        System.out.println("当前日期所在月的第二天: " + SecondDayOfMonth);

        System.out.println("当前日期的前一天(minus): " + today.minusDays(1));
        System.out.println("当前日期的前一天(plus): " + today.plusDays(-1));
        System.out.println("当前日期的后一天(plus): " + today.plusDays(1));
    }

    /**
     * LocalTime获取各种时间
     */
    public static void localTimeTest() {
        System.out.println("========LocalTime========");
        LocalTime now = LocalTime.now();
        System.out.println("当前时间: " + now);
        System.out.println("当前时间-时: " + now.getHour());
        System.out.println("当前时间-分: " + now.getMinute());
        System.out.println("当前时间-秒: " + now.getSecond());
        System.out.println("当前时间-纳秒: " + now.getNano());
        //清除时间, withXxx(0)
        System.out.println("当前时间: " + now.withHour(0).withMinute(0).withSecond(0).withNano(0));
    }

    /**
     * LocalDateTime获取日期时间
     */
    public static void localDateTimeTest() {
        System.out.println("========LocalDateTime========");
        long timestamp = System.currentTimeMillis();
        System.out.println("当前时间戳: " + timestamp);
        long epochSeconds = System.currentTimeMillis() / 1000L;
        System.out.println("当前时间(秒): " + epochSeconds);
        ZoneId zoneId = ZoneOffset.systemDefault();
        System.out.println("时区: " + zoneId);

        //根据传入的时间进行操作
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(epochSeconds), zoneId);
        System.out.println("localDateTime: " + localDateTime);
        System.out.println("当前年: " + localDateTime.getYear());
        System.out.println("当前月: " + localDateTime.getMonth());
        System.out.println("当前日(一个月中的第几天): " + localDateTime.getDayOfMonth());
        System.out.println("当前日(一个周中的第几天): " + localDateTime.getDayOfWeek());
        System.out.println("当前时间-时: " + localDateTime.getHour());
        System.out.println("当前时间-分: " + localDateTime.getMinute());
        System.out.println("当前时间-秒: " + localDateTime.getSecond());
        System.out.println("当前时间-纳秒: " + localDateTime.getNano());

        long dayStartSeconds = localDateTime.withHour(0).withMinute(0).withSecond(0).atZone(zoneId).toEpochSecond();
        System.out.println("传入时间某一天零分零秒的秒数: " + dayStartSeconds);

        System.out.println("当前日(一个周中的第几天)-ordinal: " + localDateTime.getDayOfWeek().ordinal());
        LocalDateTime weekStart = localDateTime.minusDays(localDateTime.getDayOfWeek().ordinal()).withHour(0).withMinute(0).withSecond(0);
        System.out.println("传入时间当前周第一天的零分零秒: " + weekStart);

        long monthStartSeconds = localDateTime.with(TemporalAdjusters.firstDayOfMonth()).withHour(0).withMinute(0).withSecond(0).atZone(zoneId).toEpochSecond();
        System.out.println("传入时间当前月第一天零分零秒的秒数: " + monthStartSeconds);

        LocalDateTime firstDayOfYear = localDateTime.with(TemporalAdjusters.firstDayOfYear());
        System.out.println("传入时间当前年的第一天: " + firstDayOfYear);

        LocalDateTime plusOneWeek = localDateTime.plusWeeks(1);
        System.out.println("当前时间向后推一周: " + plusOneWeek);
        LocalDateTime minusOneWeek = localDateTime.minusWeeks(1);
        System.out.println("当前时间向前推一周: " + minusOneWeek);

        //格式转换
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String happyTime = "2000-01-01 00:00";
        localDateTime = LocalDateTime.parse(happyTime, formatter);
        System.out.println(localDateTime);
    }
}
