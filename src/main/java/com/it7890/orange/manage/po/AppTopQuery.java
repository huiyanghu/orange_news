package com.it7890.orange.manage.po;

/**
 * Created by Administrator on 2017/5/27.
 */
public class AppTopQuery {
    private String objectId;
    private String countryCode;
    private Integer ctype;
    private String startTime;
    private String endTime;
    private Integer status;//1正常 0禁用 -1删除
    private Integer itype;

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Integer getCtype() {
        return ctype;
    }

    public void setCtype(Integer ctype) {
        this.ctype = ctype;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getItype() {
        return itype;
    }

    public void setItype(Integer itype) {
        this.itype = itype;
    }

    @Override
    public String toString() {
        return "AppTopQuery{" +
            "objectId='" + objectId + '\'' +
            ", countryCode='" + countryCode + '\'' +
            ", ctype=" + ctype +
            ", startTime='" + startTime + '\'' +
            ", endTime='" + endTime + '\'' +
            '}';
    }
}
