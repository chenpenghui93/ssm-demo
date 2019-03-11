package com.example.ssmdemo.hello.template;

import org.apache.poi.xwpf.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author cph
 * @date 2019/3/11
 */
public class Template {

    private XWPFDocument document;

    public XWPFDocument getDocument() {
        return document;
    }

    public void setDocument(XWPFDocument document) {
        this.document = document;
    }

    public Template(FileInputStream fileInputStream) throws IOException {
        document = new XWPFDocument(fileInputStream);
    }

    /**
     * 文档替换
     *
     * @param dataMap
     */
    public void replaceDocumnet(Map dataMap) {

        //获取模板所有对象（段落+表格）
        List<IBodyElement> bodyElementList = document.getBodyElements();
        //标记模板对象个数
        int size = bodyElementList.size();
        //当前操作的段落对象索引
        int curP = 0;
        //当前操作的表格对象索引
        int curT = 0;

        for (int i = 0; i < size; i++) {
            IBodyElement body = bodyElementList.get(i);
            if (BodyElementType.TABLE.equals(body.getElementType())) {
                //处理表格


            } else if (BodyElementType.PARAGRAPH.equals(body.getElementType())) {
                //处理段落
                XWPFParagraph paragraph = body.getBody().getParagraphArray(curP);
                if (paragraph != null) {

                    addParagraphInDocFooter(paragraph, dataMap, 0);

                    curP++;
                }

            } else {
                System.out.println("模板文件错误：含有不支持的内容");
            }
        }

        //模板处理完毕后删除原始模板内容
        for (int i=0; i<size; i++) {
            document.removeBodyElement(i);
        }

    }

    /**
     * 根据 模板段落 和 数据 在文档末尾生成新段落
     *
     * @param paragraph
     * @param dataMap
     * @param flag      0-不循环替换，1-循环替换
     */
    public void addParagraphInDocFooter(XWPFParagraph paragraph, Map dataMap, int flag) {
        if (flag == 0) {
            //创建新段落
            XWPFParagraph createParagraph = document.createParagraph();
            //设置段落样式
            createParagraph.getCTP().setPPr(paragraph.getCTP().getPPr());
            //移除原始内容
            for (int j = 0; j < createParagraph.getRuns().size(); j++) {
                createParagraph.removeRun(j);
            }
            //添加Run标签
            for (XWPFRun run : paragraph.getRuns()) {
                XWPFRun newRun = createParagraph.createRun();
                newRun.getCTR().setRPr(run.getCTR().getRPr());
                newRun.setText(run.text());
            }
            //进行数据替换
            replaceParagraph(createParagraph, dataMap);

        } else if (flag == 1) {

        }
    }

    /**
     * 替换段落内的变量{name}、{date}等
     *
     * @param createParagraph
     * @param dataMap
     */
    public void replaceParagraph(XWPFParagraph createParagraph, Map dataMap) {
        List<XWPFRun> runList = createParagraph.getRuns();
        String createParagraphText = createParagraph.getText();
        String regEx = "\\{.+?\\}";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(createParagraphText);

        if (matcher.find()) {
            int beginRunIndex = createParagraph.searchText("{", new PositionInParagraph()).getBeginRun();
            int endRunIndex = createParagraph.searchText("}", new PositionInParagraph()).getEndRun();
            StringBuffer key = new StringBuffer();

            if (beginRunIndex == endRunIndex) {
                XWPFRun beginRun = runList.get(beginRunIndex);
                String beginRunText = beginRun.text();

                int beginIndex = beginRunText.indexOf("{");
                int endIndex = beginRunText.indexOf("}");
                int length = beginRunText.length();

                if (beginIndex == 0 && endIndex == length - 1) {
                    //标签只有{**}在单个Run内
                    XWPFRun insertNewRun = createParagraph.insertNewRun(beginRunIndex);
                    insertNewRun.getCTR().setRPr(beginRun.getCTR().getRPr());
                    key.append(beginRunText.substring(1, endIndex));
                    insertNewRun.setText(getValueByKey(key.toString(), dataMap));
                    createParagraph.removeRun(beginRunIndex + 1);
                } else {
                    //标签{**}前后有内容，替换key后需要加上前后文本
                    XWPFRun insertNewRun = createParagraph.insertNewRun(beginRunIndex);
                    insertNewRun.getCTR().setRPr(beginRun.getCTR().getRPr());
                    key.append(beginRunText.substring(beginRunText.indexOf("{") + 1, beginRunText.indexOf("}")));
                    String textString = beginRunText.substring(0, beginIndex) + getValueByKey(key.toString(), dataMap)
                            + beginRunText.substring(endIndex + 1);
                    insertNewRun.setText(textString);
                    createParagraph.removeRun(beginRunIndex + 1);
                }
            } else {
                //标签{**}被分到多个Run内
                XWPFRun beginRun = runList.get(beginRunIndex);
                String beginRunText = beginRun.text();
                int beginIndex = beginRunText.indexOf("{");
                if (beginRunText.length() > 1) {
                    key.append(beginRunText.substring(beginIndex + 1));
                }
                //需要移除的Run
                ArrayList<Integer> removeRunList = new ArrayList<>();
                for (int i = beginRunIndex + 1; i < endRunIndex; i++) {
                    XWPFRun run = runList.get(i);
                    String runText = run.text();
                    key.append(runText);
                    removeRunList.add(i);
                }

                // 获取endRun中的key值
                XWPFRun endRun = runList.get(endRunIndex);
                String endRunText = endRun.text();
                int endIndex = endRunText.indexOf("}");
                //run中**}或者**}**
                if (endRunText.length() > 1 && endIndex != 0) {
                    key.append(endRunText.substring(0, endIndex));
                }

                /*
                * 开始标签
                 */
                if (beginRunText.length() == 2) {
                    XWPFRun insertNewRun = createParagraph.insertNewRun(beginRunIndex);
                    insertNewRun.getCTR().setRPr(beginRun.getCTR().getRPr());
                    // 设置文本
                    insertNewRun.setText(getValueByKey(key.toString(), dataMap));
                    //移除原始Run
                    createParagraph.removeRun(beginRunIndex + 1);
                } else {
                    XWPFRun insertNewRun = createParagraph.insertNewRun(beginRunIndex);
                    insertNewRun.getCTR().setRPr(beginRun.getCTR().getRPr());
                    // 设置文本
                    String textString = beginRunText.substring(0, beginRunText.indexOf("{")) + getValueByKey(key.toString(), dataMap);
                    insertNewRun.setText(textString);
                    createParagraph.removeRun(beginRunIndex + 1);
                }

                /*
                * 结束标签
                 */
                if (beginRunText.length() == 1) {
                    // run标签内文本只有}
                    XWPFRun insertNewRun = createParagraph.insertNewRun(endRunIndex);
                    insertNewRun.getCTR().setRPr(endRun.getCTR().getRPr());
                    // 设置文本
                    insertNewRun.setText("");
                    //移除原始Run
                    createParagraph.removeRun(endRunIndex + 1);
                } else {
                    // 该run标签为**}**或者 }** 或者**}，替换key后，还需要加上原始key后的文本
                    XWPFRun insertNewRun = createParagraph.insertNewRun(endRunIndex);
                    insertNewRun.getCTR().setRPr(endRun.getCTR().getRPr());
                    // 设置文本
                    String textString = endRunText.substring(endRunText.indexOf("}") + 1);
                    insertNewRun.setText(textString);
                    //移除原始的run
                    createParagraph.removeRun(endRunIndex + 1);
                }

                /*
                * 处理中间的run标签
                 */
                for (int i = 0; i < removeRunList.size(); i++) {
                    //原始Run
                    XWPFRun xWPFRun = runList.get(removeRunList.get(i));
                    XWPFRun insertNewRun = createParagraph.insertNewRun(removeRunList.get(i));
                    insertNewRun.getCTR().setRPr(xWPFRun.getCTR().getRPr());
                    insertNewRun.setText("");
                    //移除原始
                    createParagraph.removeRun(removeRunList.get(i) + 1);
                }
            }

            replaceParagraph(createParagraph, dataMap);

        }
    }

    /**
     * @param key
     * @param map
     * @return
     */
    public String getValueByKey(String key, Map<String, Object> map) {
        String value = "";
        if (key != null) {
            try {
                value = map.get(key) != null ? map.get(key).toString() : "";
            } catch (Exception e) {
                System.out.println("key=" + key);
                e.printStackTrace();
            }
        }
        return value;
    }


}
