package com.example.toolkit.common.syncldap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


/**
 * @author chenpenghui
 * @date 2020/7/25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LdapServiceTest {

    @Autowired
    private LdapService ldapService;

    @Test
    public void syncLdapTest() {
        String accessToken = ldapService.getLdapAccessToken();
        List<LdapUser> list = ldapService.getLdapUserList(accessToken, "");
        System.out.println(list.size());
    }

}