package com.example.toolkit.common.syncldap;

import lombok.Data;
import lombok.ToString;

/**
 * @author chenpenghui
 * @date 2020/7/21
 */
@Data
@ToString
public class LdapUser {
    private String employeeNumber;
    private String uid;
    private String mail;
    private String title;
    private String departmentNumber;
    private String ou;
    private String o;
    private String cn;
    private String cnen;
    private String telephoneNumber;
    private String userType;
    private String mobile;
    private String idNumber;
    private String otherDepartments;
    private String udpateTime;
    private String modifyTimestamp;
}
