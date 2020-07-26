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

        // 全量用户
        List<LdapUser> userList = ldapService.getLdapUserList(null);
        System.out.println(userList.size());
        // 指定用户
        List<LdapUser> user = ldapService.getLdapUserList("xxx");
        System.out.println(user.size());

    }

    @Test
    public void syncOrgTest() {
        // 全量组织
        List<LdapDept> deptList = ldapService.getLdapDeptList(null);
        System.out.println(deptList.size());
    }

}