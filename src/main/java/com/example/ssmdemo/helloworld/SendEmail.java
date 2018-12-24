package com.example.ssmdemo.helloworld;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * 1.发送简单 E-mail
 * 2.发送HTML E-mail
 * 3.发送带附件的E-mail
 *
 * @author cph
 * @version 1.0.0
 * @date 2018/12/21
 */
public class SendEmail {

    public static void main(String[] args) {

        sendSimpleEmail();

    }

    public static void sendSimpleEmail(){

        String to = "";
        String from = "";
        String host = "smtp.163.com";
        String subject = "This is the Subject Line!";
        String content = "This is actual message";

        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.put("mail.smtp.auth", true);

        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("", "");
            }
        });

        session.setDebug(true);

        try {

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            //发送-TO，抄送-CC，密送-BCC
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setText(content);
            Transport.send(message);
            System.out.println("sent message successfully···");

        }catch (Exception e) {

        }


    }

    public static void sendHTMLEmail(){

    }

    public static void sendAttachmentsEmail(){

    }

}
