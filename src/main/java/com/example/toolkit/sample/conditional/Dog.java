package com.example.toolkit.sample.conditional;

import org.springframework.stereotype.Service;

/**
 * @author chenpenghui
 * @date 2020-12-31
 */
//@Service
public class Dog implements Animal {
    @Override
    public String eat() {
        return "meat";
    }
}
