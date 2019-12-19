package com.example.ssmdemo.helloworld.set;

/**
 * @author cph
 * @date 2019/12/11
 */
public class Employee {
    private Long id;
    private String name;
    private String phone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Employee(Long id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }
}