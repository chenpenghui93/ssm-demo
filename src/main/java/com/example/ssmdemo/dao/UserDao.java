package com.example.ssmdemo.dao;

import com.example.ssmdemo.model.User;
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

    /**
     * 根据姓名获取用户
     *
     * @param name
     * @return
     */
    User selectUserByName(String name);

    /**
     * 查询所有用户
     *
     *  @param
     * @return
     */
    List<Map> getAll();

}
