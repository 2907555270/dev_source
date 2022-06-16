package com.txy.utils;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class HelloPDF {
    public static void main(String[] args) throws IOException, DocumentException {
        String outPath = "/home/flyme/Git_Project/dev_source/project/demo1/hello.pdf";
        String fontPath = "/home/flyme/Git_Project/dev_source/project/demo1/src/main/webapp/lib/font/element-icons.ttf";
        String content = "/home/flyme/Git_Project/dev_source/project/demo1/src/main/webapp/login.html";

        //TODO:创建文档：默认A4页面
        Document document = new Document();
        //自定义页面
        ////设置大小
        //Rectangle pageSize = new Rectangle(300, 500);
        ////设置背景颜色
        //pageSize.setBackgroundColor(BaseColor.GRAY);
        ////设置边框颜色
        //pageSize.setBorderColor(BaseColor.BLACK);
        ////创建文档
        //Document document = new Document(pageSize);

        try{
            //TODO:创建PdfWriter实例：可设置pdf的各种属性
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(outPath));
            //设置每行的间距
            writer.setInitialLeading(30);

            //TODO:打开文档
            document.open();

            //TODO:设置文档信息
            document.addAuthor("flyme txy");
            document.addCreationDate();
            document.addTitle("Hello pdf");

            //TODO:字体--解决中文问题
            BaseFont baseFont = BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            Font font = new Font(baseFont);
            font.setColor(BaseColor.BLACK);
            font.setStyle(Font.NORMAL);

            //TODO：添加内容--String-->paragraph(或其他类型)-->document
            //String content = "<h1>Hello pdf,我的第一个PDF</h1>";
            Paragraph paragraph = new Paragraph(content,font);
            //将一段落尽量放在同一页中:不总是有效
            paragraph.setKeepTogether(true);

            ////TODO:内容块，最小基本组成单位
            //Chunk chunk = new Chunk("下标");
            //// 设置字体，字体定宽
            //chunk.setFont(new Font(baseFont, 4));
            //// 设置背景颜色
            //chunk.setBackground(new BaseColor(0xFF, 0xFF, 0x00));
            //// 设置上表下标
            //chunk.setTextRise(-3f);
            //paragraph.add(chunk);

            //TODO:将内容添加到document中
            document.add(paragraph);

            //TODO:
            PdfContentByte cb = writer.getDirectContent();
            cb.fill();
            cb.sanityCheck();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //TODO:关闭文档
            document.close();
        }




    }
}
