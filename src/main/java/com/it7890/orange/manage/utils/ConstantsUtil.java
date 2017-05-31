package com.it7890.orange.manage.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/5/27.
 */
public class ConstantsUtil {
    public static Map getAppTopArtitypeAll(){
        Map map = new HashMap();
        map.put(0, "文字文章");
        map.put(1, "图文文章");
        map.put(2, "视频文章");
        map.put(3, "链接文章");
        map.put(4, "H5游戏文章");
        map.put(5, "竞猜文章");
        map.put(6, "游戏文章");
        map.put(7, "其他");
        return map;
    }
    public static String getAppTopArtitypeStr(String artitype) {
        Map map = getAppTopArtitypeAll();
        if (StringUtil.isNotNull(artitype)) {
            Pattern pattern = Pattern.compile("[0-9]*");
            Matcher isNum = pattern.matcher(artitype);
            if (isNum.matches()) {
                if (null != map.get(Integer.parseInt(artitype))) {
                    return "" + map.get(Integer.parseInt(artitype));
                }
            }
        }
        return "";
    }
    public static Map getAppTopCtypeAll(){
        Map map = new HashMap();
        map.put("1", "文章");
        map.put("2", "竞猜");
        map.put("3", "广告");
        return map;
    }
    public static String getAppTopCtypeStr(String ctype) {
        Map map = getAppTopCtypeAll();
        if (StringUtil.isNotNull(ctype)) {
            Pattern pattern = Pattern.compile("[0-9]*");
            Matcher isNum = pattern.matcher(ctype);
            if (isNum.matches()) {
                if (null != map.get(ctype)) {
                    return "" + map.get(ctype);
                }
            }
        }
        return "";
    }
}
