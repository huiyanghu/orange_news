
package com.it7890.orange.manage.model;

import java.io.Serializable;
import java.sql.Timestamp;



/**
 * @Description: 
 * @date 2015年12月10日 下午2:04:59
 */
public class AppPushInfo  implements Serializable{
	
	private int id;
	//国家ID
	private int cid;
	//文章中的articleid
	private String articleid;
	//文章标题
	private String title;
	//状态
	private int status;
	//推送时间
	private Timestamp pushtime;
	//推送数量
	private int pushnum;
	
	private String starttime;
	
	private String endtime;
	
	private String countrycode;
	
	
	public String getCountrycode() {
		return countrycode;
	}
	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getArticleid() {
		return articleid;
	}
	public void setArticleid(String articleid) {
		this.articleid = articleid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Timestamp getPushtime() {
		return pushtime;
	}
	public void setPushtime(Timestamp pushtime) {
		this.pushtime = pushtime;
	}
	public int getPushnum() {
		return pushnum;
	}
	public void setPushnum(int pushnum) {
		this.pushnum = pushnum;
	}
	
	
}

