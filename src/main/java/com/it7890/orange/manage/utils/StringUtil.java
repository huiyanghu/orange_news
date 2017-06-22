package com.it7890.orange.manage.utils;

import java.io.BufferedInputStream;
import java.sql.Blob;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 字符串处理工具类
 *
 * @author zhoujie
 *         <p>
 *         2011-6-13
 */
public class StringUtil {

    private static List<String> modulelist = null;

    public static SimpleDateFormat sdff = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static SimpleDateFormat sdffdate = new SimpleDateFormat("yyyy-MM-dd");

    public static String formatDateYYYYMMDDHHMMSS(Date date) {
        String str = sdff.format(date);
        return str;
    }

    public static List<String> getModuleList() {
        if (modulelist == null) {
            modulelist = new ArrayList<String>();
            modulelist.add("SM");
            modulelist.add("CS");
            modulelist.add("BM");
            modulelist.add("BI");
        }
        return modulelist;
    }

    /**
     * 判断字符串是否为空
     *
     * @param str 字符串
     * @return 是 return true 不是返回 false
     */
    public static boolean isNotNull(String str) {
        if (str != null && str.length() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isNotEmpty(Object object) {
        if (object != null && !"".equals(object)) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(Object object) {
        if (object == null || "".equals("" + object)) {
            return true;
        }
        return false;
    }

    public static String doTimeString(String timeS) {
        if (timeS != null && timeS.indexOf(".") != -1) {
            timeS = timeS.substring(0, timeS.indexOf("."));
        }
        return timeS;
    }


    /**
     * Blob to String
     *
     * @param blob
     * @return Mar 11, 2012 5:27:28 PM
     */
    public static String blobToString(Blob blob) {
        try {
            BufferedInputStream bi = new BufferedInputStream(
                blob.getBinaryStream());
            byte[] data = new byte[(int) blob.length()];
            String outfile = "";
            bi.read(data);
            outfile = new String(data);
            bi.close();
            return outfile;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * string To Blob
     *
     * @param content
     * @return Mar 11, 2012 5:28:51 PM
     */

    public static Blob stringToBlob(String content) {
        try {
            return new javax.sql.rowset.serial.SerialBlob(
                content.getBytes());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
