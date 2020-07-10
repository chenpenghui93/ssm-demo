package com.example.toolkit.domain;

import lombok.Data;

/**
 * @author cph
 * @version 1.0
 * @date 2018/12/17
 */
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
