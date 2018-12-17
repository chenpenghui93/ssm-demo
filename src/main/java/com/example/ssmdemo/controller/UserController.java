package com.example.ssmdemo.controller;

import com.example.ssmdemo.dao.UserDao;
import com.example.ssmdemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cph
 * @version 1.0
 * @date 2018/12/17
 */
@RestController
public class UserController {

    @Autowired
    UserDao userDao;

    @RequestMapping(value = "getUser")
    public User getUser() {
        User user = userDao.selectUserByName("张三");
        return user;
    }
}
