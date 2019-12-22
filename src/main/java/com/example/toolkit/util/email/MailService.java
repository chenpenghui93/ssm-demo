package com.example.toolkit.util.email;

/**
 * @author cph
 * @date 2019/5/15
 */
public interface MailService {

    void sendHtmlMail(String to, String subject, String content);

}
