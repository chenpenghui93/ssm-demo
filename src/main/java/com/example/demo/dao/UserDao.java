package com.example.demo.dao;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author cph
 * @version 1.0
 * @date 2018/12/17
 */
@Mapper
@Repository
public interface UserDao {

    void addUser(Map map);

    void updateUser(Map map);

    void deleteUser(Long id);

    User getUser(long id);

    List<User> getAllUsers();

}
