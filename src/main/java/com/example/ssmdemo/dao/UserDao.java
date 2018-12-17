package com.example.ssmdemo.dao;

import com.example.ssmdemo.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author cph
 * @version 1.0
 * @date 2018/12/17
 */
@Mapper
@Repository
public interface UserDao {

    User selectUserByName(String name);

}
