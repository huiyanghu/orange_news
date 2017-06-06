package com.it7890.orange.manage.po;

/**
 * Created by wyq on 2017/6/6.
 */
public class RecommendQuery {
    private int page;
    private int pushNum;
    private String countryCode;
    private String startTime;
    private String endTime;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPushNum() {
        return pushNum;
    }

    public void setPushNum(int pushNum) {
        this.pushNum = pushNum;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
