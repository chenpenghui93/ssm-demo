package com.example.ssmdemo.hello.template;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.BodyElementType;
import org.apache.poi.xwpf.usermodel.IBodyElement;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

/**
 * 1.读取word模板
 * 2.发送html email
 */
public class WordTemplate {

    public static void main(String[] args) {
        String content = readFromWord("D:/", "认购出资通知.docx");
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
            XWPFWordExtractor xwpfWordExtractor = new XWPFWordExtractor(POIXMLDocument.openPackage(path));
            text = xwpfWordExtractor.getText();
            System.out.println(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }
}
