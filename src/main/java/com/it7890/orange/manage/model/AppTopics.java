package com.it7890.orange.manage.model;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;

/**
 * @author zhoujie@7890it.com
 * @ClassName: AppTopics
 * @Description:
 * @date 2015年10月15日 下午5:17:43
 */
@AVClassName("AppTopics")
public class AppTopics extends AVObject {
    /*public AppTopics() {
        super();
    }*/
    /*
    public String topicName;
    */

    public String getTopicName() {
        return getString("topicName");
    }

    public void setTopicName(String topicName) {

        this.put("topicName", topicName);
    }
}
