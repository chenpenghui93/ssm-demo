package com.example.toolkit.sample.conditional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author chenpenghui
 * @date 2020-12-31
 */
@SpringBootApplication
public class TestApplication implements CommandLineRunner {

    @Autowired
    private Animal animal;

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

    @Override
    public void run(String... args) {
        String eat = animal.eat();
        System.out.println(eat);
    }
}
