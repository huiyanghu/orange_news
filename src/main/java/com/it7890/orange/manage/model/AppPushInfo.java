
package com.it7890.orange.manage.model;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;

import java.util.Date;


/**
 * @Description:
 * @date 2015年12月10日 下午2:04:59
 */
@AVClassName("AppPushInfo")
public class AppPushInfo extends AVObject {
    private static final long serialVersionUID = 1L;

    public AppPushInfo() {
        super();
    }

    /**
     * 表中字段
     */
    private String objectId;
    private String countryObjectId;
    private String articleObjectId;
    private String title;
    private Integer status;//0:未推送，1推送中，2已推送
    private Date pushTime=new Date();
    private Integer pushNum;

    @Override
    public String getObjectId() {
        return objectId;
    }

    @Override
    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getCountryObjectId() {
        return countryObjectId;
    }

    public void setCountryObjectId(String countryObjectId) {
        this.countryObjectId = countryObjectId;
    }

    public String getArticleObjectId() {
        return articleObjectId;
    }

    public void setArticleObjectId(String articleObjectId) {
        this.articleObjectId = articleObjectId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getPushTime() {
        return pushTime;
    }

    public void setPushTime(Date pushTime) {
        this.pushTime = pushTime;
    }

    public Integer getPushNum() {
        return pushNum;
    }

    public void setPushNum(Integer pushNum) {
        this.pushNum = pushNum;
    }


}

