package com.chenji.demo.pdf.api.service;

import com.chenji.demo.pdf.api.common.utils.FtpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * Created by chenji on 2017/9/25.
 */
@Service
public class FtpService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${nc.api.ftpIp}")
    private String ftpIp;

    @Value("${nc.api.ftpUsername}")
    private String ftpUsername;

    @Value("${nc.api.ftpPsw}")
    private String ftpPsw;

    @Value("${nc.api.ftpRootPath}")
    private String ftpRootPath;

    /**
     * 上传pdf到ftp.
     * @param tempPdf   pdf file
     * @return ftp 全路径
     */
    public String uploadPdf(File tempPdf) {
        FtpUtil ftpUtil = new FtpUtil();
        try {
            ftpUtil.connect(ftpRootPath, ftpIp, ftpUsername, ftpPsw);
            boolean isUpload = ftpUtil.upload(tempPdf);
            if (isUpload) {
                return "ftp://"+ftpIp+"/zhuying/"+ tempPdf.getName();
            }
        } catch (Exception e) {
            logger.error("上传PDF到FTP异常",e);
        }finally {
            //删除暂存文件
            tempPdf.delete();
        }
        return null;
    }
}
