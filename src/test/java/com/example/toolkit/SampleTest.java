package com.example.toolkit;

import com.example.toolkit.domain.User;
import com.example.toolkit.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chenpenghui
 * @date 2020/7/10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Configuration
public class SampleTest {

    @Resource
    private UserMapper userMapper;

    // TODO: 2020/7/10 调通单元测试框架：junit4、junit5
    @Test
    public void testSelect() {
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }
}
