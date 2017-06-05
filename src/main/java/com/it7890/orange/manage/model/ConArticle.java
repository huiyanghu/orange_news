package com.it7890.orange.manage.model;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;


/**
 * The persistent class for the con_articles database table.
 */
@AVClassName("conarticle")
public class ConArticle extends AVObject {
    private static final long serialVersionUID = 1L;

    public ConArticle() {
        super();
    }

    public String objectId;
    public String countrycode;
    public String title;
    public String abstracts;

    @Override
    public String getObjectId() {
        return objectId;
    }

    @Override
    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstracts() {
        return abstracts;
    }

    public void setAbstracts(String abstracts) {
        this.abstracts = abstracts;
    }
}