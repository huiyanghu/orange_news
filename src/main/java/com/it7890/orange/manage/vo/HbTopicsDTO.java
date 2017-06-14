package com.it7890.orange.manage.vo;

import com.avos.avoscloud.AVObject;

/**
 * Created by Administrator on 2017/6/12.
 */
public class HbTopicsDTO {

    private String hid;
    private String tid;
    private int topicType;
    private String topicName;
    private String topicIcon;
    private String topicIconId;

    private String keyWords;
    private int checked;

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

    public String getTopicIconId() {
        return topicIconId;
    }

    public void setTopicIconId(String topicIconId) {
        this.topicIconId = topicIconId;
    }

    public static HbTopicsDTO avo2dto(AVObject avo){
        HbTopicsDTO hbTopicsDTO = null;
        if (avo!=null){
            hbTopicsDTO = new HbTopicsDTO();
            hbTopicsDTO.setHid(avo.getObjectId());
            if (avo.getAVFile("topicIconFile")!=null){
                hbTopicsDTO.setTopicIcon(avo.getAVFile("topicIconFile").getUrl());
                hbTopicsDTO.setTopicIconId(avo.getAVFile("topicIconFile").getObjectId());
            }
            hbTopicsDTO.setTopicName(avo.getString("Name"));
            hbTopicsDTO.setTopicType(avo.getInt("topictype"));
        }
        return hbTopicsDTO;
    }
}
