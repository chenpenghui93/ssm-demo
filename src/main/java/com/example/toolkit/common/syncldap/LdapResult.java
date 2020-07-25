package com.example.toolkit.common.syncldap;

import lombok.Data;

import java.util.List;

/**
 * @author chenpenghui
 * @date 2020/7/21
 */
@Data
public class LdapResult {
    /**
     * 返回结果
     */
    private LdapResponse result;

    /**
     * 用户列表
     */
    private List<LdapUser> data;
}
