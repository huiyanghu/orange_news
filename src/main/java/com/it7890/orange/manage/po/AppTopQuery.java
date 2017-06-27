package com.it7890.orange.manage.po;

/**
 * Created by Administrator on 2017/5/27.
 */
public class AppTopQuery {
    private String objectId;
    private String countryCode;
    private String countryObjectId;
    private String languagesObjectId;
    private Integer ctype;
    private String startTime;
    private String endTime;
    private Integer status;//0正常 1禁用 2删除
    private Integer itype;
    private Integer longitude;
    private Integer latitude;

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

    public String getCountryObjectId() {
        return countryObjectId;
    }

    public void setCountryObjectId(String countryObjectId) {
        this.countryObjectId = countryObjectId;
    }

    public String getLanguagesObjectId() {
        return languagesObjectId;
    }

    public void setLanguagesObjectId(String languagesObjectId) {
        this.languagesObjectId = languagesObjectId;
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

    public Integer getLongitude() {
        return longitude;
    }

    public void setLongitude(Integer longitude) {
        this.longitude = longitude;
    }

    public Integer getLatitude() {
        return latitude;
    }

    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "AppTopQuery{" +
            "objectId='" + objectId + '\'' +
            ", countryCode='" + countryCode + '\'' +
            ", countryObjectId='" + countryObjectId + '\'' +
            ", languagesObjectId='" + languagesObjectId + '\'' +
            ", ctype=" + ctype +
            ", startTime='" + startTime + '\'' +
            ", endTime='" + endTime + '\'' +
            ", status=" + status +
            ", itype=" + itype +
            ", longitude=" + longitude +
            ", latitude=" + latitude +
            '}';
    }
}
