package com.example.toolkit.common.syncldap;

import lombok.Data;

/**
 * @author chenpenghui
 * @date 2020/7/21
 */
@Data
public class LdapResponse {
    private String code;
    private String msg;
    private String accessToken;
    private String expireTime;
}
