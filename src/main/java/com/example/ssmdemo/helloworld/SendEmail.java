package com.example.ssmdemo.helloworld;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
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

        sendEmail();

    }

    public static void sendEmail() {
        //收件邮箱
        String to = "cph_2001@163.com";
        //发件邮箱
        String from = "mcmadmin@163.com";

        Properties properties = new Properties();
        //指定发送邮件的主机
        properties.put("mail.host", "smtp.163.com");
        //指定邮件发送协议
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.auth", true);

        try {
            //===========第一步：获取Session对象=============
            //获取session对象
            Session session = Session.getInstance(properties);
            //控制台打印会话日志
            session.setDebug(true);

            //===========第二步：获取Transport对象============
            //通过session获取Transport对象
            Transport transport = session.getTransport();
            transport.connect(from, "客户端授权密码");

            //===========第三步：创建MimeMessage对象并设置信息==
            //创建邮件对象
            MimeMessage message = new MimeMessage(session);
            //设置发件人
            message.setFrom(new InternetAddress(from));
            //设置收件人，type：TO/CC/BCC分别表示发送/抄送/密送
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            //邮件主题
            message.setSubject("神秘的西夏");

            //邮件正文-简单邮件
            message.setText("神秘的西夏");

//            //邮件正文-HTML邮件
//            message.setContent("<h1>hello, world!<h1>", "text/html");

//            //邮件正文-带附件邮件
//            BodyPart messageBodyPart = new MimeBodyPart();
//            messageBodyPart.setText("大白高的王，有十种吉祥？");
//            Multipart multipart = new MimeMultipart();
//            multipart.addBodyPart(messageBodyPart);
//            //附件
//            messageBodyPart = new MimeBodyPart();
//            String filename = "D:\\devRepo\\ssm-demo\\src\\main\\resources\\static\\img\\road.jpg";
//            DataSource dataSource = new FileDataSource(filename);
//            messageBodyPart.setDataHandler(new DataHandler(dataSource));
//            messageBodyPart.setFileName(filename);
//            multipart.addBodyPart(messageBodyPart);
//            message.setContent(multipart);

            //============第四步：使用Transport对象发送邮件==========
            //发送邮件
            transport.sendMessage(message, message.getAllRecipients());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
