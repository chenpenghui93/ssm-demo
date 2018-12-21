package com.example.ssmdemo.helloworld;

import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * 发送简单 E-mail
 * 发送HTML E-mail
 * 发送带附件的E-mail
 *
 * @author cph
 * @version 1.0.0
 * @date 2018/12/21
 */
public class SendEmail {

    public static void main(String[] args) {



    }

    private static void sendSimpleEmail() {
        String to = "cph_2001@163.com";
        String from = "mcmadmin@163.com";
        String host = "smtp.163.com";
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("mcmadmin@163.com", "sqm163");
            }
        });
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("It's not your fault!");
            message.setText("安若木槿，静待花开");
            Transport.send(message);
            System.out.println("sent message successfully...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void sendSimpleEmail2(){
        Properties properties = new Properties();
        properties.put("mail.host", "smtp.163.com");
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.auth", true);

        Session session = Session.getDefaultInstance(properties);
        session.setDebug(true);
        try {
            Transport transport = session.getTransport();
            transport.connect("mcmadmin@163.com", "sqm163");
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("mcmadmin@163.com"));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress("chenpenghui@hisense.com"));
            message.setSubject("邮件主题测试");
            message.setText("安若木槿，静待花开");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
