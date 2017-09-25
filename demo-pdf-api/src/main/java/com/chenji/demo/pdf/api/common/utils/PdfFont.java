package com.chenji.demo.pdf.api.common.utils;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by chenji on 2017/9/8.
 */
public class PdfFont extends XMLWorkerFontProvider {
    private static Logger logger = LoggerFactory.getLogger(PdfFont.class);

    public PdfFont() {
        super(null, null);
    }

    @Override
    public Font getFont(final String fontname, final String encoding,
                        final boolean embedded, final float size, final int style,
                        final BaseColor color) {
        BaseFont bf = null;
        try {
            bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        } catch (Exception e) {
            logger.error("getFont异常",e);
        }
        Font font = new Font(bf, size, style, color);
        font.setColor(color);
        return font;
    }
}
