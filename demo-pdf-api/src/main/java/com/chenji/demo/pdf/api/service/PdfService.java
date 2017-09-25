package com.chenji.demo.pdf.api.service;

import com.chenji.demo.pdf.api.common.utils.FreemarkerUtil;
import com.chenji.demo.pdf.api.common.utils.PdfFileUtil;
import com.chenji.demo.pdf.api.common.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

/**
 * Created by chenji on 2017/8/30.
 */
@Service
public class PdfService {

    private static Logger logger = LoggerFactory.getLogger(PdfService.class);


    private static final String FTLNAME = "ftl/protocol.ftl";

    @Value("${nc.api.tempPath}")
    private String tempPath;

    /**
     * 生成并上传pdf文件.
     */

    public File buildPdf(Map<String,?> ftpData, String LoanAgreementNum) throws IOException {

        //pdf 暂存文件.
        File tempPdf = null;

        //生成pdf信息.
        String pdfContent =null;
        try{
            pdfContent=FreemarkerUtil.loadFtlHtml(new File(tempPath), FTLNAME, ftpData);
            if(StringUtil.isEmpty(pdfContent)){
                logger.warn("loadFtlHtml出错");
                return null;
            }
        }
        catch (Exception e){
            logger.error("loadFtlHtml异常",e);
            return null;
        }

        //生成pdf文件.
        FileOutputStream fileOutputStream = null;
        try {
            tempPdf = new File(tempPath + "/" +LoanAgreementNum +".pdf");
            fileOutputStream = new FileOutputStream(tempPdf);
            PdfFileUtil.savePdf(fileOutputStream, pdfContent);
        }catch (Exception e) {
            logger.error("生成pdf文件异常.", e);
            return null;
        } finally {
            if (null != fileOutputStream) {
                fileOutputStream.close();
            }
        }
        return tempPdf;
    }
}
