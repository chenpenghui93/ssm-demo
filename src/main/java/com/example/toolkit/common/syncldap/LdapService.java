package com.example.toolkit.common.syncldap;

import com.alibaba.fastjson.JSONObject;
import org.apache.axis.Constants;
import org.apache.axis.encoding.XMLType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.xml.namespace.QName;
import javax.xml.rpc.Call;
import javax.xml.rpc.ParameterMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 同步LDAP服务
 *
 * @author chenpenghui
 * @date 2020/7/17
 */
@Service
public class LdapService {

    private final Logger log = LoggerFactory.getLogger(LdapService.class);

    private RestTemplate restTemplate = new RestTemplate();

    @Value("${ldap.tokenUrl}")
    private String tokenUrl;

    @Value("${ldap.eidClass}")
    private String eidClass;

    @Value("${ldap.user.appSecretId}")
    private String appSecretId;

    @Value("${ldap.user.appSecretKey}")
    private String appSecretKey;

    @Value("${ldap.user.endPoint}")
    private String endpoint;

    /**
     * 获取accessToken
     *
     * @return accessToken
     */
    public String getLdapAccessToken() {
        String getTokenUrl = tokenUrl + "?appSecretId=" + appSecretId + "&appSecretKey=" + appSecretKey + "&eidClass=" + eidClass;
        LdapResponse LdapResponse = restTemplate.getForObject(getTokenUrl, LdapResponse.class);
        return LdapResponse.getTokenId();
    }

    /**
     * 获取LDAP用户列表
     *
     * @param accessToken
     * @param params
     * @return List<LdapUser>
     */
    public List<LdapUser> getLdapUserList(String accessToken, String params) {
        List<LdapUser> ldapUserList = new ArrayList<>();
        try {
            org.apache.axis.client.Service service = new org.apache.axis.client.Service();
            Call call = service.createCall();
            call.setTargetEndpointAddress(endpoint);
            call.setOperationName(new QName("http://services.soap.ws.esc.para.com/", "ldapQueryInfoParams"));
            call.addParameter("access_token", Constants.XSD_ANYTYPE, ParameterMode.IN);
            call.addParameter("appSecretId", Constants.XSD_ANYTYPE, ParameterMode.IN);
            call.addParameter("eidClass", Constants.XSD_ANYTYPE, ParameterMode.IN);
            call.addParameter("params", Constants.XSD_ANYTYPE, ParameterMode.IN);
            call.setReturnType(XMLType.XSD_STRING);
            log.info("查询LDAP用户 开始 ...");
            String result = (String) call.invoke(new Object[]{accessToken, appSecretId, eidClass, ""});
            log.info("查询LDAP用户 结束 ...");
            LdapResult ldapResult = JSONObject.parseObject(result, LdapResult.class);
            if (Objects.nonNull(ldapResult) && "SUCCESS".equals(ldapResult.getResult().getResCode())) {
                ldapUserList = ldapResult.getData();
            }
        } catch (Exception e) {
            log.info("获取用户列表异常：" + e.getMessage());
        }
        return ldapUserList;
    }

}
