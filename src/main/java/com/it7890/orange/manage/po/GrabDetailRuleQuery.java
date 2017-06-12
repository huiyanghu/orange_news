package com.it7890.orange.manage.po;

/**
 * Created by Administrator on 2017/6/12.
 */
public class GrabDetailRuleQuery {
    private String objectId;
    private String grabDetailRuleObjectId;
    private String ruleName;
    private Integer status;

    private String titleCssPath;    //文章标题区域规则
    private String descCssPath;     //文章描述区域规则
    private String conCssPath;      //文章内容区域规则
    private String replaceCssPath;  //剔除内容区域规则
    private String souCssPath;      //来源区域规则
    private String imgCssPath;      //图片规则
    private String videoCssPath;    //媒体规则
    private String authorCssPath;   //作者规则
    private String keywordCssPath;  //关键字规则
    private String testUrl;         //测试url

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getGrabDetailRuleObjectId() {
        return grabDetailRuleObjectId;
    }

    public void setGrabDetailRuleObjectId(String grabDetailRuleObjectId) {
        this.grabDetailRuleObjectId = grabDetailRuleObjectId;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTitleCssPath() {
        return titleCssPath;
    }

    public void setTitleCssPath(String titleCssPath) {
        this.titleCssPath = titleCssPath;
    }

    public String getDescCssPath() {
        return descCssPath;
    }

    public void setDescCssPath(String descCssPath) {
        this.descCssPath = descCssPath;
    }

    public String getConCssPath() {
        return conCssPath;
    }

    public void setConCssPath(String conCssPath) {
        this.conCssPath = conCssPath;
    }

    public String getReplaceCssPath() {
        return replaceCssPath;
    }

    public void setReplaceCssPath(String replaceCssPath) {
        this.replaceCssPath = replaceCssPath;
    }

    public String getSouCssPath() {
        return souCssPath;
    }

    public void setSouCssPath(String souCssPath) {
        this.souCssPath = souCssPath;
    }

    public String getImgCssPath() {
        return imgCssPath;
    }

    public void setImgCssPath(String imgCssPath) {
        this.imgCssPath = imgCssPath;
    }

    public String getVideoCssPath() {
        return videoCssPath;
    }

    public void setVideoCssPath(String videoCssPath) {
        this.videoCssPath = videoCssPath;
    }

    public String getAuthorCssPath() {
        return authorCssPath;
    }

    public void setAuthorCssPath(String authorCssPath) {
        this.authorCssPath = authorCssPath;
    }

    public String getKeywordCssPath() {
        return keywordCssPath;
    }

    public void setKeywordCssPath(String keywordCssPath) {
        this.keywordCssPath = keywordCssPath;
    }

    public String getTestUrl() {
        return testUrl;
    }

    public void setTestUrl(String testUrl) {
        this.testUrl = testUrl;
    }
}
