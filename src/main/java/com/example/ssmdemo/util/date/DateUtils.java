package com.example.ssmdemo.util.date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author cph
 * @date 2019/6/28
 */
public class DateUtils {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = "2019-06-27";
        LocalDate localDate = LocalDate.parse(date, formatter);

        System.out.println(localDate);
    }
}
