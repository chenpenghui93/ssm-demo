package com.example.toolkit.sample.template;

import fr.opensagres.poi.xwpf.converter.xhtml.XHTMLConverter;
import fr.opensagres.poi.xwpf.converter.xhtml.XHTMLOptions;
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
        File inputFile = new File("D:\\devRepo\\zTemplate\\电子控股老股东2018年期权认购通知（老股东-集团主管-标准修订）.docx");
        FileInputStream fileInputStream = new FileInputStream(inputFile);
        Template template = new Template(fileInputStream);

        //3.替换数据
        template.replaceDocumnet(dataMap);

        //4.生成文件
        File outputFile = new File("D:\\devRepo\\zTemplate\\电子控股老股东2018年期权认购通知（老股东-集团主管-标准修订）实例.docx");
        FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
        template.getDocument().write(fileOutputStream);

        //5.转换为html
        File wordFile = new File("D:\\devRepo\\zTemplate\\电子控股老股东2018年期权认购通知（老股东-集团主管-标准修订）实例.docx");
        InputStream inputStream = new FileInputStream(wordFile);
        XWPFDocument document = new XWPFDocument(inputStream);

        File htmlFile = new File("D:\\devRepo\\zTemplate\\电子控股老股东2018年期权认购通知（老股东-集团主管-标准修订）实例.html");
        OutputStream out = new FileOutputStream(htmlFile);
        XHTMLOptions options = XHTMLOptions.create();
        XHTMLConverter.getInstance().convert(document, out, options);

        //6.读取html
        String content = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader("D:\\devRepo\\zTemplate\\电子控股老股东2018年期权认购通知（老股东-集团主管-标准修订）实例.html"));
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                content += str;
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //7.发送邮件
        SendEmail sendEmailService = new SendEmail();
        sendEmailService.sendEmail("html", "cph_2001@163.com", "认购Subject", content);

    }
}
