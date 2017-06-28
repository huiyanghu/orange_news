package com.it7890.orange.manage.model;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;

/**
 * Created by Administrator on 2017/6/28.
 */
@AVClassName("AppKeywords")
public class AppKeywords extends AVObject {
    /*private HbCountrys country;
    private String keyword;
    private Integer keywordType;
    private SysUser createUser;*/

    public HbCountrys getCountry() {
        return getAVObject("countryObj");
    }

    public void setCountry(HbCountrys country) {
        this.put("countryObj", country);
    }

    public String getKeyword() {
        return getString("keyword");

    }

    public void setKeyword(String keyword) {
        this.put("keyword", keyword);
    }

    public Integer getKeywordType() {
        return getInt("keywordType");
    }

    public void setKeywordType(Integer keywordType) {
        this.put("keywordType", keywordType);
    }

    public SysUser getCreateUser() {
        return getAVObject("createUserObj");
    }

    public void setCreateUser(SysUser createUser) {
        this.put("createUserObj", createUser);
    }
}
