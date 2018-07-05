package com.chenji.demo.pdf.api.controller;

import com.chenji.demo.pdf.api.common.utils.StringUtil;
import com.chenji.demo.pdf.api.model.dto.pdfModel.PdfModel;
import com.chenji.demo.pdf.api.service.FtpService;
import com.chenji.demo.pdf.api.service.PdfService;
import org.apache.commons.beanutils.BeanMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Map;

/**
 * Created by wangzhigang on 2017/4/14.
 */
@RestController
@RequestMapping("/")
public class CommonController {

    @Autowired
    PdfService pdfService;
    @Autowired
    FtpService ftpService;
    /*灰度发布所依赖，方法返回OK才会上线*/
    @RequestMapping(value = "/hs")
    public void ok(HttpServletResponse response) throws Exception {

        response.getWriter().print("OK");
    }

    //测试
    public String buildAndUploadPdf(PdfModel pdfModel, String loanAgreementNumber) {
        try {

            Map ftpData= new BeanMap(pdfModel);
            File tempPdf = pdfService.buildPdf(ftpData,loanAgreementNumber);
            if (null == tempPdf) {
                return "";
            }

            String ftpFullPath = ftpService.uploadPdf(tempPdf);
            if (StringUtil.isEmpty(ftpFullPath)) {
                return "";
            }
            return ftpFullPath;

        } catch (Exception e) {
        }
        return "";
    }
}
