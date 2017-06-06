package com.it7890.orange.manage.model;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;

import java.util.Date;

/**
 * @author zhoujie@7890it.com
 * @ClassName: AppTopics
 * @Description:
 * @date 2015年10月15日 下午5:17:43
 */
@AVClassName("AppTopics")
public class AppTopics extends AVObject {
    public AppTopics() {
        super();
    }

    private int id;
    private int countryid;
    private int topicid;
    private String topicicon;
    private String topicname;
    private String hubiiid;
    private int topictype;
    private String keywords;
    private int rank;
    private int pubstatus;
    private int channelid;
    private int createuid;
    private Date createtime;


    public int getPubstatus() {
        return pubstatus;
    }

    public void setPubstatus(int pubstatus) {
        this.pubstatus = pubstatus;
    }

    public int getChannelid() {
        return channelid;
    }

    public void setChannelid(int channelid) {
        this.channelid = channelid;
    }

    /**
     * @return hubiiid
     * @author zhoujie@7890it.com
     * @date 2015年10月16日 下午5:16:34
     */
    public String getHubiiid() {
        return hubiiid;
    }

    /**
     * @param hubiiid 要设置的 hubiiid
     * @author zhoujie@7890it.com
     * @date 2015年10月16日 下午5:16:34
     */
    public void setHubiiid(String hubiiid) {
        this.hubiiid = hubiiid;
    }

    /**
     * @return topictype
     * @author zhoujie@7890it.com
     * @date 2015年10月16日 下午5:16:34
     */
    public int getTopictype() {
        return topictype;
    }

    /**
     * @param topictype 要设置的 topictype
     * @author zhoujie@7890it.com
     * @date 2015年10月16日 下午5:16:34
     */
    public void setTopictype(int topictype) {
        this.topictype = topictype;
    }

    /**
     * @return keywords
     * @author zhoujie@7890it.com
     * @date 2015年10月16日 下午5:16:34
     */
    public String getKeywords() {
        return keywords;
    }

    /**
     * @param keywords 要设置的 keywords
     * @author zhoujie@7890it.com
     * @date 2015年10月16日 下午5:16:34
     */
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    /**
     * @return topicicon
     * @author zhoujie@7890it.com
     * @date 2015年10月15日 下午6:17:40
     */
    public String getTopicicon() {
        return topicicon;
    }

    /**
     * @param topicicon 要设置的 topicicon
     * @author zhoujie@7890it.com
     * @date 2015年10月15日 下午6:17:40
     */
    public void setTopicicon(String topicicon) {
        this.topicicon = topicicon;
    }

    /**
     * @return rank
     * @author zhoujie@7890it.com
     * @date 2015年10月15日 下午6:52:09
     */
    public int getRank() {
        return rank;
    }

    /**
     * @param rank 要设置的 rank
     * @author zhoujie@7890it.com
     * @date 2015年10月15日 下午6:52:09
     */
    public void setRank(int rank) {
        this.rank = rank;
    }

    /**
     * @return topicname
     * @author zhoujie@7890it.com
     * @date 2015年10月15日 下午5:36:07
     */
    public String getTopicname() {
        return topicname;
    }

    /**
     * @param topicname 要设置的 topicname
     * @author zhoujie@7890it.com
     * @date 2015年10月15日 下午5:36:07
     */
    public void setTopicname(String topicname) {
        this.topicname = topicname;
    }

    /**
     * @return id
     * @author zhoujie@7890it.com
     * @date 2015年10月15日 下午5:21:16
     */
    public int getId() {
        return id;
    }

    /**
     * @param id 要设置的 id
     * @author zhoujie@7890it.com
     * @date 2015年10月15日 下午5:21:16
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return countryid
     * @author zhoujie@7890it.com
     * @date 2015年10月15日 下午5:21:16
     */
    public int getCountryid() {
        return countryid;
    }

    /**
     * @param countryid 要设置的 countryid
     * @author zhoujie@7890it.com
     * @date 2015年10月15日 下午5:21:16
     */
    public void setCountryid(int countryid) {
        this.countryid = countryid;
    }

    /**
     * @return topicid
     * @author zhoujie@7890it.com
     * @date 2015年10月15日 下午5:21:16
     */
    public int getTopicid() {
        return topicid;
    }

    /**
     * @param topicid 要设置的 topicid
     * @author zhoujie@7890it.com
     * @date 2015年10月15日 下午5:21:16
     */
    public void setTopicid(int topicid) {
        this.topicid = topicid;
    }

    /**
     * @return createuid
     * @author zhoujie@7890it.com
     * @date 2015年10月15日 下午5:21:16
     */
    public int getCreateuid() {
        return createuid;
    }

    /**
     * @param createuid 要设置的 createuid
     * @author zhoujie@7890it.com
     * @date 2015年10月15日 下午5:21:16
     */
    public void setCreateuid(int createuid) {
        this.createuid = createuid;
    }

    /**
     * @return createtime
     * @author zhoujie@7890it.com
     * @date 2015年10月15日 下午5:21:16
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * @param createtime 要设置的 createtime
     * @author zhoujie@7890it.com
     * @date 2015年10月15日 下午5:21:16
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }


}
