package com.chenji.demo.pdf.api.common.utils;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created by chenji on 2017/8/30.
 */
public class FtpUtil {
    private FTPClient ftp;

    /**
     * ftp服务器连接.
     * @param path 上传到ftp服务器哪个路径下
     * @param addr 地址
     * @param username 用户名
     * @param password 密码
     * @return
     * @throws Exception
     */
    public boolean connect(String path,String addr,String username,String password) throws Exception {
        boolean result = false;
        ftp = new FTPClient();
        int reply;
        ftp.connect(addr);
        ftp.login(username,password);
        ftp.enterLocalPassiveMode();
        ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
        reply = ftp.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            ftp.disconnect();
            return result;
        }
        if(!StringUtil.isEmpty(path)) {
            ftp.changeWorkingDirectory(path);
        }
        result = true;
        return result;
    }
    /**
     * 上传的文件.
     * @param file
     * @throws Exception
     */
    public Boolean upload(File file) throws Exception {
        Boolean result = false;
        FileInputStream input = null;
        try {
            File file2 = new File(file.getPath());
            input = new FileInputStream(file2);
            String str = new String(file2.getName().getBytes("UTF-8"), "iso-8859-1");
            result = ftp.storeFile(str, input);
        } finally {
            if (null != input) {
                input.close();
            }
            if (null != ftp && ftp.isConnected()) {
                ftp.logout();
                ftp.disconnect();
            }
        }
        return result;
    }
}
