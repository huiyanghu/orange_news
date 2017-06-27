package com.it7890.orange.manage.model;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVFile;
import com.avos.avoscloud.AVObject;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the con_articles database table.
 */
@AVClassName("conarticle")
public class ConArticle extends AVObject {

    /*public String abstracts;
    public Integer attr;
    public String author;
    public String authorheadimg;
    public ConChannel channel;
    public List<File> contentPicArr;
    public String countryCode;
    public Integer createUserId;
    public Integer ctype;
    public String endtime;
    public GrabDetailRule grabDetailRule;
    public GrabListRule grabListRule;
    public Integer imagecount;
    public String keywords;
    public HbLanguage language;
    public Integer latitude;
    public String linkurl;
    public Integer longitude;
    public String medialink;
    public GlobalNode node;
    public String plogo;
    public ConPublication publication;
    public Integer pushNum;
    public Date pushtime;
    public Integer rank;
    public String salt;
    public String source;
    public String sourcetitilepic;
    public String sourceurl;
    public String starttime;
    public Integer status;
    public Date subtime;
    public Integer subuid;
    public String title;
    public AppTopics topics;
    public List<File> titlePicArr;
    public Integer viewCount;
    public String writer;*/


    public String getAbstracts() {
        return getString("abstracts");
    }

    public void setAbstracts(String abstracts) {
        this.put("abstracts", abstracts);
    }

    public Integer getAttr() {
        return getInt("attr");
    }

    public void setAttr(Integer attr) {
        this.put("attr", attr);
    }

    public String getAuthor() {
        return getString("author");
    }

    public void setAuthor(String author) {
        this.put("author", author);
    }

    public String getAuthorheadimg() {
        return getString("authorheadimg");
    }

    public void setAuthorheadimg(String authorheadimg) {
        this.put("authorheadimg", authorheadimg);
    }

    public ConChannel getChannel() {
        return this.getAVObject("channelObj");
    }

    public void setChannel(ConChannel channel) {
        this.put("channelObj", channel);
    }

    public List<AVFile> getContentPicArr() {

        return getList("contentPicObjArr");
    }

    public void setContentPicArr(List<AVFile> contentPicArr) {
        this.put("contentPicObjArr", contentPicArr);
    }

    public String getCountryCode() {
        return getString("countrycode");
    }

    public void setCountryCode(String countryCode) {
        this.put("countrycode", countryCode);
    }

    public Integer getCreateUserId() {
        return getInt("createuid");
    }

    public void setCreateUserId(Integer createUserId) {
        this.put("createuid", createUserId);
    }

    public Integer getCtype() {
        return getInt("ctype");
    }

    public void setCtype(Integer ctype) {
        this.put("ctype", ctype);
    }

    public String getEndtime() {
        return getString("endtime");
    }

    public void setEndtime(String endtime) {
        this.put("endtime", endtime);
    }

    public GrabDetailRule getGrabDetailRule() {
        return getAVObject("grabDetailRuleObj");
    }

    public void setGrabDetailRule(GrabDetailRule grabDetailRule) {
        this.put("grabDetailRuleObj", grabDetailRule);
    }

    public GrabListRule getGrabListRule() {
        return getAVObject("grabListRuleObj");
    }

    public void setGrabListRule(GrabListRule grabListRule) {
        this.put("grabListRuleObj", grabListRule);
    }

    public Integer getImagecount() {
        return getInt("imgcount");
    }

    public void setImagecount(Integer imagecount) {
        this.put("imgcount", imagecount);
    }

    public String getKeywords() {
        return getString("keywords");
    }

    public void setKeywords(String keywords) {
        this.put("keywords", keywords);
    }

    public HbLanguage getLanguage() {
        return getAVObject("languageObj");
    }

    public void setLanguage(HbLanguage language) {
        this.put("languageObj", language);
    }

    public Integer getLatitude() {
        return getInt("latitude");
    }

    public void setLatitude(Integer latitude) {
        this.put("latitude", latitude);
    }

    public String getLinkurl() {
        return getString("linkurl");
    }

    public void setLinkurl(String linkurl) {
        this.put("linkurl", linkurl);
    }

    public Integer getLongitude() {
        return getInt("longitude");
    }

    public void setLongitude(Integer longitude) {
        this.put("longitude", longitude);
    }

    public String getMedialink() {
        return getString("medialink");
    }

    public void setMedialink(String medialink) {
        this.put("medialink", medialink);
    }

    public GlobalNode getNode() {
        return getAVObject("nodeObj");
    }

    public void setNode(GlobalNode node) {
        this.put("nodeObj", node);
    }

    public String getPlogo() {
        return getString("plogo");
    }

    public void setPlogo(String plogo) {
        this.put("plogo", plogo);
    }

    public ConPublication getPublication() {
        return getAVObject("publicationObj");
    }

    public void setPublication(ConPublication publication) {
        this.put("publicationObj", publication);
    }

    public Integer getPushNum() {
        return getInt("pushnum");
    }

    public void setPushNum(Integer pushNum) {
        this.put("pushnum", pushNum);
    }

    public Date getPushtime() {
        return getDate("pushtime");
    }

    public void setPushtime(Date pushtime) {
        this.put("pushtime", pushtime);
    }

    public Integer getRank() {
        return getInt("rank");
    }

    public void setRank(Integer rank) {
        this.put("rank", rank);
    }

    public String getSalt() {
        return getString("salt");
    }

    public void setSalt(String salt) {
        this.put("salt", salt);
    }

    public String getSource() {
        return getString("source");
    }

    public void setSource(String source) {
        this.put("source", source);
    }

    public String getSourcetitilepic() {
        return getString("sourcetitilepic");
    }

    public void setSourcetitilepic(String sourcetitilepic) {
        this.put("sourcetitilepic", sourcetitilepic);
    }

    public String getSourceurl() {
        return getString("sourceurl");
    }

    public void setSourceurl(String sourceurl) {
        this.put("sourceurl", sourceurl);
    }

    public String getStarttime() {
        return getString("starttime");
    }

    public void setStarttime(String starttime) {
        this.put("starttime", starttime);
    }

    public Integer getStatus() {
        return getInt("status");
    }

    public void setStatus(Integer status) {
        this.put("status", status);
    }

    public Date getSubtime() {
        return getDate("subtime");
    }

    public void setSubtime(Date subtime) {
        this.put("subtime", subtime);
    }

    public Integer getSubuid() {
        return getInt("subuid");
    }

    public void setSubuid(Integer subuid) {
        this.put("subuid", subuid);
    }

    public String getTitle() {
        return getString("title");
    }

    public void setTitle(String title) {
        this.put("title", title);
    }

    public AppTopics getTopics() {
        return getAVObject("topicObj");
    }

    public void setTopics(AppTopics topics) {
        this.put("topicObj", topics);
    }

    public List<AVFile> getTitlePicArr() {
        return getList("titlePicObjArr");
    }

    public void setTitlePicArr(List<AVFile> titlePicArr) {
        this.put("titlePicObjArr", titlePicArr);
    }

    public Integer getViewCount() {
        return getInt("viewCount");
    }

    public void setViewCount(Integer viewCount) {
        this.put("viewCount", viewCount);
    }

    public String getWriter() {
        return getString("writer");
    }

    public void setWriter(String writer) {
        this.put("writer", writer);
    }
}