package com.example.toolkit.common.syncldap;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


/**
 * @author chenpenghui
 * @date 2020/7/25
 */
@SpringBootTest
class LdapServiceTest {

    @Autowired
    private LdapService ldapService;

    @Test
    public void syncLdapTest() {
        String accessToken = ldapService.getLdapAccessToken();
        List<LdapUser> list = ldapService.getLdapUserList(accessToken, "");
        System.out.println(list.size());
    }

}