package com.example.toolkit;

import com.example.toolkit.sample.quartz.QuartzTableService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 启动类
 *
 * @author cph
 * @version 1.0
 * @date 2018/12/17
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.example.toolkit.mapper")
@EnableAsync
public class Application {

    @Autowired
    QuartzTableService quartzTableService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

