package com.example.ssmdemo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.ssmdemo.dao.UserDao;
import com.example.ssmdemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

    /**
     *
     */
    @RequestMapping(value = "/hello")
    public String hello() {
        return "hello, world!";
    }

    /**
     * 根据姓名查询用户
     *
     * @return
     */
    @RequestMapping(value = "getUser")
    public User getUser() {
        User user = userDao.selectUserByName("张三");
        return user;
    }

    /**
     * 查询所有用户
     *
     * @return
     */
    @RequestMapping(value = "getAll")
    public List getAll() {
        List<Map> userList = userDao.getAll();
        return userList;
    }

    /**
     * 查询json形式
     *
     * @return
     */
    @RequestMapping(value = "getJSONString")
    public List<Map> getJSONString() {

        Map map = userDao.getJSONString();
        String string = map.get("text").toString();
        System.out.println(string);

        List<Map> objectList = JSON.parseObject(string, List.class);
        System.out.println(objectList);

        List<Map> arrayList = JSON.parseArray(string, Map.class);
        System.out.println(arrayList);

        return objectList;
    }

    @RequestMapping(value = "getUserById")
    @ResponseBody
    public HttpServletResponse getUserById(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject obj) {
        Map params = new HashMap();
        params.put("id", obj.get("id"));
        Map map = userDao.getUserById(params);
        String data = JSON.toJSONString(map);

//        OutputStream outputStream = null;
//        try {
//            response.setHeader("Content-type", "application/json;charset=utf-8");
//            outputStream = response.getOutputStream();
//            outputStream.write(data.getBytes("utf-8"));
//        } catch (Exception e){
//            e.printStackTrace();
//        }

        PrintWriter printWriter = null;
        try {
            response.setHeader("Content-type", "application/json;charset=utf-8");
            printWriter = response.getWriter();
            printWriter.print(data);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != printWriter) {
                printWriter.close();
            }
        }

        return response;

    }
}
