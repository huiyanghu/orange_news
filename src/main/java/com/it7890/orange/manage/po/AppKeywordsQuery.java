package com.it7890.orange.manage.po;

/**
 * Created by Administrator on 2017/6/28.
 */
public class AppKeywordsQuery {
    private Integer keywordType;// 0=热词 1=敏感词
    private String countryObjectId;
    private String objectId;

    public Integer getKeywordType() {
        return keywordType;
    }

    public void setKeywordType(Integer keywordType) {
        this.keywordType = keywordType;
    }

    public String getCountryObjectId() {
        return countryObjectId;
    }

    public void setCountryObjectId(String countryObjectId) {
        this.countryObjectId = countryObjectId;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }
}
