package com.it7890.orange.manage.model;

import com.alibaba.fastjson.JSON;
import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * The persistent class for the con_articles database table.
 */
@AVClassName("conarticle")
public class ConArticle extends AVObject {
    private static final long serialVersionUID = 1L;

    public ConArticle() {
        super();
    }
    private long id;
    private String abstracts;//简介
    private String articleid;
    private String countrycode;
    //    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date subtime;
    private String title;
    private String titlepic;//缩略图
    private int topicsid;//话题id
    private String langid;
    private String linkurl;
    private int attr;
    private String author;
    private int channelid;
    private Date createtime;
    private int createuid;
    private int ctype;
    private int imgcount;
    private String keywords;
    private float latitude;
    private float longitude;
    private String medialink;
    private int publicationid;
    private float rank;
    private String source;
    private String sourceurl;
    private int status;
    private int subuid;
    private String writer;
    private String sourcetitilepic;
    private String starttime;
    private String endtime;
    private int pushnum;
    //    private Timestamp pushtime;//发布日期
    private String plogo;
    private String authorheadimg;
    private AppTopics topicObj;


    public String getPlogo() {
        return getString("plogo");
    }

    public void setPlogo(String plogo) {
        this.put("plogo", plogo);
    }

    public String getAuthorheadimg() {
        return getString("authorheadimg");
    }

    public void setAuthorheadimg(String authorheadimg) {
        this.put("authorheadimg", authorheadimg);
    }

//    public Timestamp getPushtime() {
//        return
//    }
//
//    public void setPushtime(Timestamp pushtime) {
//        this.put("", );pushtime = pushtime;
//    }

    public int getPushnum() {
        return getInt("pushnum");
    }

    public void setPushnum(int pushnum) {
        this.put("pushnum", pushnum);
    }

    public String getStarttime() {
        return getString("starttime");
    }

    public void setStarttime(String starttime) {
        this.put("starttime", starttime);
    }

    public String getEndtime() {
        return getString("endtime");
    }

    public void setEndtime(String endtime) {
        this.put("endtime", endtime);
    }

    public String getTitlepic() {
        return getString("titlepic");
    }

    public void setTitlepic(String titlepic) {
        this.put("titlepic", titlepic);
    }

    public String getSourcetitilepic() {
        return getString("sourcetitilepic");
    }

    public void setSourcetitilepic(String sourcetitilepic) {
        this.put("sourcetitilepic", sourcetitilepic);
    }

    public long getId() {
        return getLong("id");
    }

    public void setId(long id) {
        this.put("id", id);
    }

    public String getAbstracts() {
        return getString("abstracts");
    }

    public void setAbstracts(String abstracts) {
        this.put("abstracts", abstracts);
    }

    public String getArticleid() {
        return getString("articleid");
    }

    public void setArticleid(String articleid) {
        this.put("articleid", articleid);
    }

    public int getAttr() {
        return getInt("attr");
    }

    public void setAttr(int attr) {
        this.put("attr", attr);
    }

    public String getAuthor() {
        return getString("author");
    }

    public void setAuthor(String author) {
        this.put("author", author);
    }

    public int getChannelid() {
        return getInt("channelid");
    }

    public void setChannelid(int channelid) {
        this.put("channelid", channelid);
    }

    public String getCountrycode() {
        return getString("countrycode");
    }

    public void setCountrycode(String countrycode) {
        this.put("countrycode", countrycode);
    }

    public Date getCreatetime() {
        return getDate("createtime");
    }

    public void setCreatetime(Date createtime) {
        this.put("createtime", createtime);
    }

    public int getCreateuid() {
        return getInt("createuid");
    }

    public void setCreateuid(int createuid) {
        this.put("createuid", createuid);
    }

    public int getCtype() {
        return getInt("ctype");
    }

    public void setCtype(int ctype) {
        this.put("ctype", ctype);
    }

    public int getImgcount() {
        return getInt("imgcount");
    }

    public void setImgcount(int imgcount) {
        this.put("imgcount", imgcount);
    }

    public String getKeywords() {
        return getString("keywords");
    }

    public void setKeywords(String keywords) {
        this.put("keywords", keywords);
    }

    public String getLangid() {
        return getString("langid");
    }

    public void setLangid(String langid) {
        this.put("langid", langid);
    }

    public float getLatitude() {
        return getInt("latitude");
    }

    public void setLatitude(float latitude) {
        this.put("latitude", latitude);
    }

    public String getLinkurl() {
        return getString("linkurl");
    }

    public void setLinkurl(String linkurl) {
        this.put("linkurl", linkurl);
    }

    public float getLongitude() {
        return getInt("longitude");
    }

    public void setLongitude(float longitude) {
        this.put("longitude", longitude);
    }

    public String getMedialink() {
        return getString("medialink");
    }

    public void setMedialink(String medialink) {
        this.put("medialink", medialink);
    }

    public int getPublicationid() {
        return getInt("publicationid");
    }

    public void setPublicationid(int publicationid) {
        this.put("publicationid", publicationid);
    }

    public float getRank() {
        return getInt("rank");
    }

    public void setRank(float rank) {
        this.put("rank", rank);
    }

    public String getSource() {
        return getString("source");
    }

    public void setSource(String source) {
        this.put("source", source);
    }

    public String getSourceurl() {
        return getString("sourceurl");
    }

    public void setSourceurl(String sourceurl) {
        this.put("sourceurl", sourceurl);
    }

    public int getStatus() {
        return getInt("status");
    }

    public void setStatus(int status) {
        this.put("status", status);
    }

    public Date getSubtime() {
        return getDate("subtime");
    }

    public void setSubtime(Date subtime) {
        this.put("subtime", subtime);
    }

    public int getSubuid() {
        return getInt("subuid");
    }

    public void setSubuid(int subuid) {
        this.put("subuid", subuid);
    }

    public String getTitle() {
        return getString("title");
    }

    public void setTitle(String title) {
        this.put("title", title);
    }

    public int getTopicsid() {
        return getInt("topicsid");
    }

    public void setTopicsid(int topicsid) {
        this.put("topicsid", topicsid);
    }

    public String getWriter() {
        return getString("writer");
    }

    public void setWriter(String writer) {
        this.put("writer", writer);
    }

    public AppTopics getTopicObj() {
        return (AppTopics) get("topicObj");
    }

    public void setTopicObj(AppTopics topicObj) {
        this.put("topicObj", topicObj);
    }

    @Override
    public String toString() {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("id", this.getLong("id"));
        result.put("abstracts", this.getString("abstracts"));
        result.put("articleid", this.getString("articleid"));
        result.put("countrycode", this.getString("countrycode"));
        result.put("subtime", this.getDate("subtime"));
        result.put("title", this.getString("title"));
        result.put("titlepic", this.getString("titlepic"));
        result.put("topicsid", this.getInt("topicsid"));
        result.put("langid", this.getString("langid"));
        result.put("linkurl", this.getString("linkurl"));
        result.put("attr", this.getInt("attr"));
        result.put("author", this.getString("author"));
        result.put("channelid", this.getInt("channelid"));
        result.put("createtime", this.getDate("createtime"));
        result.put("createuid", this.getInt("createuid"));
        result.put("ctype", this.getInt("ctype"));
        result.put("imgcount", this.getInt("imgcount"));
        result.put("keywords", this.getString("keywords"));
        result.put("latitude", this.getInt("latitude"));
        result.put("longitude", this.getInt("longitude"));
        result.put("medialink", this.getString("medialink"));
        result.put("publicationid", this.getInt("publicationid"));
        result.put("rank", this.getInt("rank"));
        result.put("source", this.getString("source"));
        result.put("sourceurl", this.getString("sourceurl"));
        result.put("status", this.getInt("status"));
        result.put("subuid", this.getInt("subuid"));
        result.put("writer", this.getString("writer"));
        result.put("sourcetitilepic", this.getString("sourcetitilepic"));
        result.put("starttime", this.getString("starttime"));
        result.put("endtime", this.getString("endtime"));
        result.put("pushnum", this.getInt("pushnum"));
        result.put("plogo", this.getString("plogo"));
        result.put("authorheadimg", this.getString("authorheadimg"));
        result.put("objectId", this.getObjectId());
        result.put("createdAt", this.getCreatedAt());
        return JSON.toJSONString(result);
    }


}