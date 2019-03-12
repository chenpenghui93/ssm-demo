package com.example.ssmdemo.hello.template;

import com.example.ssmdemo.util.SendEmailService;
import fr.opensagres.poi.xwpf.converter.xhtml.XHTMLConverter;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cph
 * @date 2019/3/11
 */
public class TemplateTest {

    public static void main(String[] args) throws IOException {
        //1.准备数据
        Map dataMap = new HashMap();
        dataMap.put("name", "张三");
        dataMap.put("date", "2019年3月11日");

        //2.读取word模板
        File inputFile = new File("D:\\devRepo\\zTemplate\\认购出资模板.docx");
        FileInputStream fileInputStream = new FileInputStream(inputFile);
        Template template = new Template(fileInputStream);

        //3.替换数据
        template.replaceDocumnet(dataMap);

        //4.生成文件
        File outputFile = new File("D:\\devRepo\\zTemplate\\认购出资实例.docx");
        FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
        template.getDocument().write(fileOutputStream);

        //5.转换为html
        File wordFile = new File("D:\\devRepo\\zTemplate\\认购出资实例.docx");
        InputStream inputStream = new FileInputStream(wordFile);
        XWPFDocument document = new XWPFDocument(inputStream);

        File htmlFile = new File("D:\\devRepo\\zTemplate\\认购出资实例.html");
        OutputStream out = new FileOutputStream(htmlFile);
        XHTMLConverter.getInstance().convert(document, out, null);

        //6.读取html
        String content = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\devRepo\\zTemplate\\认购出资实例.html"));
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                content += str;
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //7.发送邮件
        SendEmailService sendEmailService = new SendEmailService();
        sendEmailService.sendEmail("html", "cph_2001@163.com", "认购Subject", content);

    }
}
