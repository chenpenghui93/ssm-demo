package com.example.toolkit.mapper;

import com.example.toolkit.entity.User;
import com.example.toolkit.service.TransactionService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chenpenghui
 * @date 2020-10-24
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class UserMapperTest {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TransactionService service;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
    public void test1() throws Exception {
        service.ts();
    }

    @Test
    public void testTransactional(){
        List<User> userList = userMapper.selectList(null);
        List<Long> ids = userList.stream().map(User::getId).collect(Collectors.toList());
        userMapper.deleteBatchIds(ids);

        User user = new User();
        user.setId(99L);
        user.setName("zhangsan");
        user.setAge(9);
        user.setEmail("zhangsan@xxx.com");
        userMapper.insert(user);

    }

}