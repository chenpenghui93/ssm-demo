package com.example.ssmdemo.controller;

import com.alibaba.fastjson.JSON;
import com.example.ssmdemo.dao.UserDao;
import com.example.ssmdemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
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

    @RequestMapping(value = "/addUser")
    public void addUser(@RequestParam String userName, @RequestParam String userSex){
        Map map = new HashMap();
        map.put("userName", userName);
        map.put("userSex", userSex);
        userDao.addUser(map);
    }

    @RequestMapping(value = "/updateUser")
    public void updateUser(@RequestParam Long id, @RequestParam String userName, @RequestParam String userSex){
        Map map = new HashMap();
        map.put("id", id);
        map.put("userName", userName);
        map.put("userSex", userSex);
        userDao.updateUser(map);
    }

    @RequestMapping(value = "deleteUser")
    public void deleteUser(Long id) {
        Map map = new HashMap();
        map.put("id", id);
        userDao.deleteUser(map);
    }

    @RequestMapping(value = "/getUser")
    public User getUser(Long id) {
        return userDao.getUser(id);
    }

    @RequestMapping(value = "getAllUsers")
    public List<User> getAllUsers(){
        return userDao.getAllUsers();
    }

}
