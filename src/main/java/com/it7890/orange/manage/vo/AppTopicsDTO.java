package com.it7890.orange.manage.vo;

import com.avos.avoscloud.AVObject;

/**
 * Created by Administrator on 2017/6/12.
 */
public class AppTopicsDTO {

    private String hid;
    private String tid;
    private int topicType;
    private String topicName;
    private String topicIcon;
    private String keyWords;
    private int checked;
    private int rank;

    public String getHid() {
        return hid;
    }

    public void setHid(String hid) {
        this.hid = hid;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public int getTopicType() {
        return topicType;
    }

    public void setTopicType(int topicType) {
        this.topicType = topicType;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicIcon() {
        return topicIcon;
    }

    public void setTopicIcon(String topicIcon) {
        this.topicIcon = topicIcon;
    }


    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public int getChecked() {
        return checked;
    }

    public void setChecked(int checked) {
        this.checked = checked;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public static AppTopicsDTO avo2dto(AVObject avo){
        AppTopicsDTO appTopicsDTO = null;
        if (avo!=null){
            appTopicsDTO = new AppTopicsDTO();
            appTopicsDTO.setKeyWords(avo.getString("keyWords"));
            appTopicsDTO.setTid(avo.getObjectId());
            if (avo.getAVFile("topicIconFile")!=null){
                appTopicsDTO.setTopicIcon(avo.getAVFile("topicIconFile").getUrl());
            }
            appTopicsDTO.setTopicName(avo.getString("topicName"));
            appTopicsDTO.setTopicType(avo.getInt("topicType"));
            if (avo.getAVObject("HbTopicsObj")!=null){
                appTopicsDTO.setHid(avo.getAVObject("HbTopicsObj").getObjectId());
            }
            appTopicsDTO.setRank(avo.getInt("rank"));
        }
        return appTopicsDTO;
    }
}
