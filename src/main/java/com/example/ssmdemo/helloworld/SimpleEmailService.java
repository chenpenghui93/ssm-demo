package com.example.ssmdemo.helloworld;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

/**
 * @author cph
 * @date 2019/3/6
 **/
@Service
@ComponentScan
public class SimpleEmailService {

    public static void main(String[] args) {

        String type = "simple";
        String to = "chenpenghui@hisense.com";
        String subject = "2100年分红报告";
        String content = "http://hisense-hstock-web-hisense-stock-test.devapp.hisense.com/TopDown/Home";

        sendEmail(type, to, subject, content);
    }

    public static void sendEmail(String type, String to, String subject, String content) {
        //发件箱
//        String from = "mcmadmin@163.com";
        String from = "stocksys@hisense.com";
        Properties properties = new Properties();
        //发件主机
//        properties.put("mail.host", "smtp.163.com");
        properties.put("mail.host", "mail.hisense.com");
        //发件协议
        properties.put("mail.transport.protocol", "smtp");
        //鉴权
        properties.put("mail.smtp.auth", true);

        try {
            //1.获取session对象
            Session session = Session.getInstance(properties);
            session.setDebug(true);
            //2.获取transport对象
            Transport transport = session.getTransport();
            transport.connect(from, "a*403190");
            //3.创建MimeMessage对象并设置收件人、发送方式、发件人、主题、内容等
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            //TO/CC/BCC分别表示发送/抄送/密送
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            //邮件主题
            message.setSubject(subject);
            if (type == "simple") {
                System.out.println("=====simple email=====");
                message.setText(content);
            } else if (type == "html") {
                System.out.println("=====html email text/html;charset=gbk =====");
                message.setContent(content, "text/html;charset=gbk");
            } else if (type == "attachment") {
                System.out.println("=====attachment email=====");
                //正文
                BodyPart bodyPart = new MimeBodyPart();
                bodyPart.setText("bodyPart.setText");
                Multipart multipart = new MimeMultipart();
                multipart.addBodyPart(bodyPart);
                //附件
                bodyPart = new MimeBodyPart();
                String filename = "D:\\devRepo\\ssm-demo\\README.md";
                DataSource dataSource = new FileDataSource(filename);
                bodyPart.setDataHandler(new DataHandler(dataSource));
                bodyPart.setFileName(filename);
                multipart.addBodyPart(bodyPart);
                message.setContent(multipart);
            }
            //4.发送邮件
            transport.sendMessage(message, message.getAllRecipients());

            System.out.println();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
