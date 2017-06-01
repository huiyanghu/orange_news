package com.it7890.orange.manage.utils;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/5/27.
 */
public class ConstantsUtil {
    public static Map getAppTopArtitypeAll(){
        Map map = new HashMap();
        map.put("0", "文字文章");
        map.put("1", "图文文章");
        map.put("2", "视频文章");
        map.put("3", "链接文章");
        map.put("4", "H5游戏文章");
        map.put("5", "竞猜文章");
        map.put("6", "游戏文章");
        map.put("7", "其他");
        return map;
    }
    public static String getAppTopArtitypeStr(String artitype) {
        Map map = getAppTopArtitypeAll();
        if (StringUtil.isNotNull(artitype)) {
            Pattern pattern = Pattern.compile("[0-9]*");
            Matcher isNum = pattern.matcher(artitype);
            if (isNum.matches()) {
                if (null != map.get(artitype)) {
                    return "" + map.get(artitype);
                }
            }
        }
        return "";
    }

    public static List<Map> getAppTopItypeAll(){
        List<Map> list=new ArrayList<Map>();
        Map map = new HashMap();
        map.put("key", "1");
        map.put("value", "文章");
        list.add(map);
        map = new HashMap();
        map.put("key", "2");
        map.put("value", "竞猜");
        list.add(map);
        map = new HashMap();
        map.put("key", "3");
        map.put("value", "广告");
        list.add(map);
        return list;
    }
    public static String getAppTopItypeStr(String ctype) {
        List<Map> list=getAppTopItypeAll();
        if (StringUtil.isNotNull(ctype)) {
            Pattern pattern = Pattern.compile("[0-9]*");
            Matcher isNum = pattern.matcher(ctype);
            if (isNum.matches()) {
                for (Map m:list) {
                    if (m.get("key")!=null&&ctype.equals(""+m.get("key"))){
                        return ""+m.get("value");
                    }
                }
            }
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSON(getAppTopItypeAll()));
        System.out.println(getAppTopItypeStr("1ss"));
    }

}
