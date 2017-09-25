package com.chenji.demo.pdf.api.common.utils;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;


/**
 * Created by chenji on 2017/8/30.
 */
public class PdfFileUtil {
    public static void savePdf(OutputStream out, String html) {
        Document document = new Document(PageSize.A4, 50, 50, 60, 60);
        try {
            PdfWriter writer = PdfWriter.getInstance(document, out);
            Charset charset = Charset.forName("UTF-8");
            document.open();
            XMLWorkerHelper.getInstance().parseXHtml(writer, document, new ByteArrayInputStream(html.getBytes("UTF-8")),null,charset,new PdfFont());
        } catch (Exception e) {
           throw new RuntimeException(e);
        } finally {
            document.close();
        }
    }
}
