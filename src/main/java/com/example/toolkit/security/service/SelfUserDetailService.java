package com.example.toolkit.security.service;

import com.example.toolkit.entity.SysUserEntity;
import com.example.toolkit.security.entity.SelfUserEntity;
import com.example.toolkit.service.SysUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author chenpenghui
 * @date 2021-2-5
 */
@Component
public class SelfUserDetailService implements UserDetailsService {

    @Autowired
    private SysUserService sysUserService;

    @Override
    public SelfUserEntity loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUserEntity sysUserEntity = sysUserService.selectUserByName(username);
        if (sysUserEntity != null) {
            SelfUserEntity selfUserEntity = new SelfUserEntity();
            BeanUtils.copyProperties(sysUserEntity, selfUserEntity);
            return selfUserEntity;
        }
        return null;
    }
}
