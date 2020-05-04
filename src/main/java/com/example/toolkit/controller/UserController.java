package com.example.toolkit.controller;

import com.example.toolkit.dao.UserDao;
import com.example.toolkit.demo.annotation.MyAnnotation;
import com.example.toolkit.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cph
 * @version 1.0
 * @date 2018/12/17
 */
@RestController
public class UserController {

    @Autowired
    UserDao userDao;

    @MyAnnotation(name = "Hello,Annotation")
    @RequestMapping(value = "/")
    public String index() {
        return "Hello World!";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addUser(@RequestParam String userName, @RequestParam String userSex) {
        Map map = new HashMap();
        map.put("userName", userName);
        map.put("userSex", userSex);
        userDao.addUser(map);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void updateUser(@RequestParam Long id, @RequestParam String userName, @RequestParam String userSex) {
        Map map = new HashMap();
        map.put("id", id);
        map.put("userName", userName);
        map.put("userSex", userSex);
        userDao.updateUser(map);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    @RequestMapping(value = "/getOne", method = RequestMethod.GET)
    public User getUser(Long id) {
        return userDao.getUser(id);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

}
