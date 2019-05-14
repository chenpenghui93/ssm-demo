package com.example.ssmdemo.helloworld.dateAndTime;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author cph
 * @date 2019/5/14
 */
public class DateAndTimeTest {

    public static void main(String[] args) {
        //获取指定格式的当前日期
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        System.out.println(sdf.format(date));

        //时间
    }
}
