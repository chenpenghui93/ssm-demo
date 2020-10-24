package com.example.toolkit.service;

import com.example.toolkit.entity.Book;
import com.example.toolkit.entity.User;
import com.example.toolkit.mapper.BookMapper;
import com.example.toolkit.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author chenpenghui
 * @date 2020-10-24
 */
@Service
public class TransactionService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BookMapper bookMapper;

    @Transactional(rollbackFor = Exception.class)
    public void ts() throws Exception {
        User user = new User();
        user.setId(6L);
        user.setName("zhangsan");
        user.setAge(33);
        user.setEmail("sdf@test.com");
        userMapper.insert(user);

        Book book = new Book();
        book.setId(1L);
        book.setBookName("百年孤独");
        book.setBookType("哲学");
        bookMapper.insert(book);

        boolean flag = true;
        if (flag) {
            try {
                throw new Exception("哎呀，出错了...");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
