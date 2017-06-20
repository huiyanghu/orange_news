package com.it7890.orange.manage.vo;

import com.avos.avoscloud.AVObject;

/**
 * @author gg
 * @create 2017/6/15
 **/
public class AppLanguagesDTO {
    private String cId;
    private String hbLangId;

    public String getHbLangId() {
        return hbLangId;
    }

    public void setHbLangId(String hbLangId) {
        this.hbLangId = hbLangId;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public static AppLanguagesDTO avo2dto(AVObject avo){
        AppLanguagesDTO appLanguagesDTO = null;
        if (avo!=null){
            appLanguagesDTO = new AppLanguagesDTO();
            appLanguagesDTO.setcId(avo.getAVObject("CountryObj").getObjectId());
            appLanguagesDTO.setHbLangId(avo.getAVObject("HbLanguageObj").getObjectId());
        }
        return appLanguagesDTO;
    }
}
