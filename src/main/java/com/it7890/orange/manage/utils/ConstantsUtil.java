package com.it7890.orange.manage.utils;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/27.
 */
public class ConstantsUtil {
    public static Map constants = new HashMap();

    static {
        constants.put("appTopArtitype", "[{'key':'0','value':'文字文章'},{'key':'1','value':'图文文章'},{'key':'2','value':'视频文章'},{'key':'3','value':'链接文章'},{'key':'4','value':'H5游戏文章'},{'key':'5','value':'竞猜文章'},{'key':'6','value':'游戏文章'},{'key':'7','value':'其他'}]");
        constants.put("appTopItype", "[{'key':'1','value':'文章'},{'key':'2','value':'竞猜'},{'key':'3','value':'广告'}]");
        constants.put("appTopStatus", "[{'key':'0','value':'正常'},{'key':'1','value':'禁用'},{'key':'2','value':'删除'}]");
        constants.put("conArticleCtype", "[{'key':'0','value':'普通'},{'key':'1','value':'推荐'},{'key':'2','value':'置顶'},{'key':'3','value':'视频'}]");
        constants.put("conArticleStatus", "[{'key':'0','value':'正常'},{'key':'1','value':'未审核'},{'key':'2','value':'预发布'}]");//-1删除
        constants.put("grabDetailRuleStatus", "[{'key':'0','value':'正常'},{'key':'1','value':'禁用'},{'key':'2','value':'删除'}]");//-1删除
        constants.put("grabListRuleStatus", "[{'key':'0','value':'正常'},{'key':'1','value':'禁用'},{'key':'2','value':'删除'}]");//-1删除
        constants.put("grabListRuleListStatus", "[{'key':'0','value':'正常'},{'key':'1','value':'禁用'},{'key':'2','value':'删除'}]");//-1删除
        constants.put("grabDetailRuleStatus", "[{'key':'0','value':'正常'},{'key':'1','value':'禁用'},{'key':'2','value':'删除'}]");//-1删除

    }

    public static List<Map> getConstants(String constantsKey) {
        List<Map> list = (List<Map>) JSON.parse("" + constants.get(constantsKey));
        return list;
    }

    public static String getConstants(String constantsKey, String key) {
        List<Map> list = getConstants(constantsKey);
        if (StringUtil.isNotEmpty(key)) {
            for (Map m : list) {
                if (m.get("key") != null && key.equals("" + m.get("key"))) {
                    return "" + m.get("value");
                }
            }
        }
        return "";
    }


//    public static void main(String[] args) {
//        List<Map> list = ConstantsUtil.getConstants("appTopArtitype");
//        System.out.println(list);
//        String value = ConstantsUtil.getConstants("appTopArtitype", "5");
//        System.out.println(value);
//    }

}
