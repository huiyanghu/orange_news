package com.it7890.orange.manage.vo;

import com.avos.avoscloud.AVObject;

/**
 * @author gg
 * @create 2017/6/7
 **/
public class HbLanguageVO {
    private String hbId;
    private String name;
    private String cnName;
    private long date;
    private String code;
    private int checked;

    public String getHbId() {
        return hbId;
    }

    public void setHbId(String hbId) {
        this.hbId = hbId;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getChecked() {
        return checked;
    }

    public void setChecked(int checked) {
        this.checked = checked;
    }

}

