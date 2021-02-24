package com.example.toolkit.sample.quartz;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author chenpenghui
 * @date 2021-2-24
 */
@Service
public class ScheduleTask {

    public void testOne() {
        System.out.println("testOne " + LocalDateTime.now());
    }

    public void testTwo() {
        System.out.println("testTwo " + LocalDateTime.now());
    }
}
