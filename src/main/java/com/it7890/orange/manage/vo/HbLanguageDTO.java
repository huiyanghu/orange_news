package com.it7890.orange.manage.vo;

import com.avos.avoscloud.AVObject;
import com.it7890.orange.manage.model.HbLanguage;

/**
 * @author gg
 * @create 2017/6/7
 **/
public class HbLanguageDTO {
    private String hbId;
    private String name;
    private String cnName;
    private long date;
    private String code;

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

    public static HbLanguageDTO avo2Dto(AVObject avo){
        HbLanguageDTO hbLanguageDTO = null;
        if(null != avo){
            hbLanguageDTO = new HbLanguageDTO();
            hbLanguageDTO.setHbId(avo.getObjectId());
            hbLanguageDTO.setDate(avo.getCreatedAt().getTime());
            hbLanguageDTO.setName(avo.getString("name"));
            hbLanguageDTO.setCode(avo.getString("codes"));
            hbLanguageDTO.setCnName(avo.getString("remark"));
        }
        return hbLanguageDTO;
    }
}

