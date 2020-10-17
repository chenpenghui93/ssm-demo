package com.example.toolkit.sample.thread;

import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * @author chenpenghui
 * @date 2020-10-17
 */
@Service
public class TestAsyncService {

    public void serviceTest() {
        Arrays.stream(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}).forEach(t -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("获取number为: " + t);
        });
    }
}
