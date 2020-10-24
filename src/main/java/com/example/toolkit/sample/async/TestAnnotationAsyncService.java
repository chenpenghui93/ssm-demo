package com.example.toolkit.sample.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * 用例 https://www.concretepage.com/spring/example_enableasync_spring
 *
 * @author chenpenghui
 * @date 2020-10-17
 */
@Service
@EnableAsync
public class TestAnnotationAsyncService {

    @Async
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
