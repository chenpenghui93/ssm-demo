package com.example.ssmdemo.hello.template;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * 1.读取word模板
 * 2.发送html email
 */
public class WordTemplate {

    public static void main(String[] args) {
        String content = readFromWord("D:/", "股权认购模板.docx");
        sendHtmlEmail("xxx", "认购征询通知", content);
    }

    /**
     * 读取word模板
     *
     * @param filePath
     * @param fileName
     * @return
     */
    public static String readFromWord(String filePath, String fileName) {
        String text = "";
        String path = filePath + "/" + fileName;
        try {
            XWPFWordExtractor docx = new XWPFWordExtractor(POIXMLDocument.openPackage(path));
            text = docx.getText();
            System.out.println(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }

    /**
     * 发送邮件
     *
     * @param to
     * @param subject
     * @param content
     */
    public static void sendHtmlEmail(String to, String subject, String content) {
        String from = "mcmadmin@163.com";

        Properties properties = new Properties();
        properties.put("mail.host", "smtp.163.com");
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.auth", true);

        try {
            Session session = Session.getInstance(properties);
            session.setDebug(true);
            Transport transport = session.getTransport();
            transport.connect(from, "xxx");
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            //设置收件人，type：TO/CC/BCC分别表示发送/抄送/密送
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setContent(content, "text/html;charset=gbk");
            transport.sendMessage(message, message.getAllRecipients());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
