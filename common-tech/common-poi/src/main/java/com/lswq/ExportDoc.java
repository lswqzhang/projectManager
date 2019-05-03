package com.lswq;

import org.apache.poi.xwpf.usermodel.*;

import java.io.*;
import java.util.*;

public class ExportDoc {

    private static String URL = "/Users/zhangsw/Desktop/Demo2.docx";

    public static void main(String[] args) throws IOException {

        ExportDoc doc = new ExportDoc();

        InputStream stream = new FileInputStream(new File(URL));
        //解析docx模板并获取document对象
        XWPFDocument document = new XWPFDocument(stream);
        //获取全部表格对象
        List<XWPFTable> allTable = document.getTables();
        XWPFTable table = allTable.get(0);
        
        System.err.println("copy");

        List<Map<String, Object>> table1 = new ArrayList<Map<String, Object>>();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("name", "张三");
        map1.put("age", "23");
        map1.put("email", "12121@qq.com");

        Map<String, Object> map2 = new HashMap<>();
        map2.put("name", "李四");
        map2.put("age", "45");
        map2.put("email", "45445@qq.com");

        Map<String, Object> map3 = new HashMap<>();
        map3.put("name", "王五");
        map3.put("age", "45");
        map3.put("email", "45445@qq.com");

        table1.add(map1);
        table1.add(map2);
        table1.add(map3);

        for (int i = 0; i < table1.size() - 1; i++) {
            XWPFTableRow source = table.getRow(2);
            table.addRow(source, 2);
        }

        

        String newPath = "/Users/zhangsw/Desktop/DemoTmp.docx";
        File newFile = new File(newPath);
        
        FileOutputStream out = new FileOutputStream(newFile);
        document.write(out);
        out.close();

        InputStream streamNew = new FileInputStream(new File(newPath));
        XWPFDocument documentNew = new XWPFDocument(streamNew);
        List<XWPFTable> newTables = documentNew.getTables();
        XWPFTable newTable = newTables.get(0);

        for (int i = 0; i < table1.size(); i++) {
            XWPFTableRow row = newTable.getRow(2 + i);
            List<XWPFTableCell> tableCells = row.getTableCells();
            Map<String, Object> stringObjectMap = table1.get(i);
            for (XWPFTableCell cell : tableCells) {
                String text = cell.getText();
                if (null != text && text.length() > 3) {
                    int length = text.length();
                    String name = text.substring(2, length - 1);
                    Object o = stringObjectMap.get(name);
                    if (Objects.nonNull(o)) {
                        List<XWPFParagraph> paragraphs = cell.getParagraphs();
                        for (XWPFParagraph p : paragraphs) {
                            List<XWPFRun> runs = p.getRuns();
                            for (XWPFRun run : runs) {
                                run.setText("", 0);
                            }
                        }
                        cell.setText(o.toString());
                    }
                }
            }
        }



        String outPath = "/Users/zhangsw/Desktop/DemoTmp_out.docx";
        File outFile = new File(outPath);

        FileOutputStream outputStream = new FileOutputStream(outFile);
        documentNew.write(outputStream);
        outputStream.close();
        newFile.delete();

    }

}
