package com.txy.utils;

import com.itextpdf.html2pdf.HtmlConverter;

import java.io.File;
import java.io.IOException;

public class HtmlToPdf {
    public static void main(String[] args) throws IOException {
        String html_path = "/home/flyme/Git_Project/dev_source/project/demo1/src/main/webapp/index_test.html";
        String pdf_path = "/home/flyme/admin.pdf";
        HtmlConverter.convertToPdf(new File(html_path),new File(pdf_path));
    }
}
