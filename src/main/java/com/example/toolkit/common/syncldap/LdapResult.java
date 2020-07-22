package com.example.toolkit.common.syncldap;

import lombok.Data;

import java.util.List;

/**
 * @author chenpenghui
 * @date 2020/7/21
 */
@Data
public class LdapResult {
    private LdapResponse ldapResponse;
    private List<LdapUser> ldapUserList;
}
