package com.chenji.demo.pdf.api.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhangyicong on 2016/10/27.
 */
public class HostUtil {
    private final static String unknownIP = "unknownIP";
    private static final String LOCAL_HOST = "127.0.0.1";

    private static Logger logger = LoggerFactory.getLogger(HostUtil.class);

    /**
     * 取本机地址
     */
    public static String getIpAddress() {
        try {
            String hostIP = InetAddress.getLocalHost().getHostAddress();
            if (!hostIP.equals(LOCAL_HOST)) {
                return hostIP;
            }
        /*
         * Above method often returns "127.0.0.1", In this case we need to
         * check all the available network interfaces
         */
            Enumeration<NetworkInterface> nInterfaces = NetworkInterface.getNetworkInterfaces();
            while (nInterfaces.hasMoreElements()) {
                try {
                    Enumeration<InetAddress> inetAddresses = nInterfaces.nextElement().getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        String address = inetAddresses.nextElement().getHostAddress();
                        if (!address.equals(LOCAL_HOST) && isIpv4(address)) {
                            return address;
                        }
                    }
                } catch (Exception e1) {
                    logger.error("getIpAddress异常", e1);
                }
            }
        } catch (Exception err) {
            logger.error("getIpAddress异常", err);
        }

        return unknownIP;
    }

    public static boolean isIpv4(String ipAddress) {

        String ip = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."
                + "(00?\\d|1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                + "(00?\\d|1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                + "(00?\\d|1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";

        Pattern pattern = Pattern.compile(ip);
        Matcher matcher = pattern.matcher(ipAddress);
        return matcher.matches();
    }

}