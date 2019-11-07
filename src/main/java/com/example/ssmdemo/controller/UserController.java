package com.example.ssmdemo.controller;

import com.example.ssmdemo.dao.UserDao;
import com.example.ssmdemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/hello")
    public String hello() {
        return "hello!";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public void addUser(@RequestParam String userName, @RequestParam String userSex){
        Map map = new HashMap();
        map.put("userName", userName);
        map.put("userSex", userSex);
        userDao.addUser(map);
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
    public void updateUser(@RequestParam Long id, @RequestParam String userName, @RequestParam String userSex){
        Map map = new HashMap();
        map.put("id", id);
        map.put("userName", userName);
        map.put("userSex", userSex);
        userDao.updateUser(map);
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.DELETE)
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public User getUser(Long id) {
        return userDao.getUser(id);
    }

    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
    public List<User> getAllUsers(){
        return userDao.getAllUsers();
    }

}
