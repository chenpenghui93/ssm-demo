package com.example.ssmdemo.hello.template;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class FreeMarkerDemo {

    public static void main(String[] args) {
        sendSimpleEmail();
    }

    public static void sendSimpleEmail() {
        String to = "";
        String from = "mcmadmin@163.com";
        Properties properties = new Properties();
        properties.put("mail.host", "smtp.163.com");
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.auth", true);

        try {
            Session session = Session.getInstance(properties);
            session.setDebug(true);

            Transport transport = session.getTransport();
            transport.connect(from, "");
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("股权认购通知书（freemarker+java mail）");

            //freemarker template
            Configuration cfg = new Configuration();
            cfg.setClassForTemplateLoading(FreeMarkerDemo.class, "/static/");
            cfg.setDefaultEncoding("UTF-8");
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            Template template = cfg.getTemplate("emailTemplate.ftl");

            //custom data
            Map paramMap = new HashMap();
            paramMap.put("name", "");
            paramMap.put("date", String.valueOf(Calendar.getInstance().getTime()));
            paramMap.put("position", "采购管理部长");
            paramMap.put("singlePrice", "100");
            paramMap.put("total", "1000");
            paramMap.put("amount", "100000");

            Writer out = new StringWriter();

            template.process(paramMap, out);
            BodyPart body = new MimeBodyPart();
            body.setContent(out.toString(), "text/html;charset=gbk");
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(body);
            message.setContent(multipart);
            transport.sendMessage(message, message.getAllRecipients());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
