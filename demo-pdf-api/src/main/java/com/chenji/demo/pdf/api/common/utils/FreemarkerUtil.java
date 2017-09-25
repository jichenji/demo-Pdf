package com.chenji.demo.pdf.api.common.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;


/**
 * Created by chenji on 2017/8/30.
 */
public class FreemarkerUtil {
    private static Logger logger = LoggerFactory.getLogger(FreemarkerUtil.class);
    /**
     * 使用传入的Map对象，渲染指定的freemarker模板
     *
     * @param baseDir 根目录
     * @param fileName 文件名
     * @param globalMap 数据绑定
     * @return html字符串
     */
    public static String loadFtlHtml(File baseDir, String fileName, Map globalMap){
        if(baseDir == null || !baseDir.isDirectory() || globalMap ==null || fileName == null || "".equals(fileName)) {
            logger.warn("loadFtlHtml异常,参数不对");
        }

        Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
        StringWriter stringWriter = null;
        try {
            cfg.setDirectoryForTemplateLoading(baseDir);
            cfg.setDefaultEncoding("UTF-8");
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);//.RETHROW
            cfg.setClassicCompatible(true);
            Template temp = cfg.getTemplate(fileName);
            stringWriter = new StringWriter();
            temp.process(globalMap, stringWriter);

            return stringWriter.toString();
        } catch (Exception e) {
            logger.error("process异常",e);
        } finally {
            if (null != stringWriter) {
                try {
                    stringWriter.close();
                } catch (IOException e) {
                    logger.error("close异常",e);
                }
            }
        }
        return null;
    }
}
