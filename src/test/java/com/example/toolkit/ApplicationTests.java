package com.example.toolkit;

import com.example.toolkit.entity.SysUserEntity;
import com.example.toolkit.entity.SysUserRoleEntity;
import com.example.toolkit.service.SysUserRoleService;
import com.example.toolkit.service.SysUserService;
import com.example.toolkit.utils.ConfigTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Autowired
    private Environment env;

    @Value("${jwt.secret}")
    private String secret;

    @Autowired
    private ConfigTest configTest;

    /**
     * 获取环境变量或系统变量三种方式
     * 1、@Value("${jwt.secret}")
     * 2、environment.getProperty("jwt.secret")
     * 3、@ConfigurationProperties
     */
    @Test
    public void t() {
        System.out.println(secret);
        System.out.println(env.getProperty("jwt.secret"));
        System.out.println(configTest);
    }

    /**
     * 注册
     */
    @Test
    public void contextLoads() {
        // 注册用户
        SysUserEntity sysUserEntity = new SysUserEntity();
        sysUserEntity.setUsername("user");
        sysUserEntity.setPassword(bCryptPasswordEncoder.encode("123456"));
        sysUserEntity.setStatus("NORMAL");
        sysUserService.save(sysUserEntity);

        // 分配角色
        SysUserRoleEntity sysUserRoleEntity = new SysUserRoleEntity();
        sysUserRoleEntity.setRoleId(2L);
        sysUserRoleEntity.setUserId(sysUserEntity.getUserId());
        sysUserRoleService.save(sysUserRoleEntity);
    }

}

