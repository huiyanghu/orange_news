package com.it7890.orange.manage.utils;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVFile;

/**
 * @author gg
 * @create 2017/6/8
 **/
public class UpLoadFileUtil {

    public static String upFile(String filename, byte[] bs){
        String fileId = "0";
        AVFile avFile = new AVFile(filename,bs);
        try {
            avFile.save();
            fileId = avFile.getObjectId();
        } catch (AVException e) {
            e.printStackTrace();
        }
        return fileId;
    }

}
