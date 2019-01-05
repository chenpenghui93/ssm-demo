package com.example.ssmdemo.hello;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * java对象与json之间互转
 * JSON：http://www.json.org/json-zh.html
 * fastjson：https://github.com/alibaba/fastjson/wiki
 * API：JSON.toJSONString()，JSON.parseObject()
 *
 * @author cph
 * @version 1.0.0
 * @date 2018/12/20
 */
public class ConvertJSON {
    public static void main(String[] args) {

        Group group = new Group();
        group.setId(1L);
        group.setName("admin");

        User guestuser = new User();
        guestuser.setId(2L);
        guestuser.setName("guest");

        User rootUser = new User();
        rootUser.setId(3L);
        rootUser.setName("root");

        group.addUser(guestuser);
        group.addUser(rootUser);

        System.out.println("group object: " + group);
        System.out.println("group object toString: " + group.toString());

        String jsonString = JSON.toJSONString(group);
        System.out.println("jsonString: " + jsonString);

        Group group1 = JSON.parseObject(jsonString, Group.class);
        System.out.println("group1: " + group1.toString());
    }

    static class Group {
        private Long id;
        private String name;
        private List<User> users = new ArrayList<>();

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

        public List<User> getUsers() {
            return users;
        }

        public void setUsers(List<User> users) {
            this.users = users;
        }

        public void addUser(User user) {
            users.add(user);
        }

        @Override
        public String toString() {
            return "Group{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", users=" + users +
                    '}';
        }
    }

    static class User {
        private Long id;
        private String name;

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

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
