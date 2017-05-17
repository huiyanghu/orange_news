package com.it7890.orange.manage.model;

import com.alibaba.fastjson.JSON;
import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@AVClassName("GlobalRule")
public class GlobalRule extends AVObject implements Serializable {

    public GlobalRule(){
        super();
    }
	
//	private int id;
//	private int pid;
//    private int nid;
//    private String rulename;
//    private String concsspath;
//	private String concsspath1;
//	private String concsspath2;
//	private String keycsspath;
//	private String videocsspath;
//	private String authorcsspath;
//	private String commentcssapth;
//	private String replacecsspath;
//	private int rank;
//	private String replacerule;
//    private String testurl;
//    private int updateuid;
    //	private Date updatetime;

//	public Date getUpdatetime() {
//		return getString("");updatetime;
//	}
//	public void setUpdatetime(Date updatetime) {
//		this.put("", );updatetime = updatetime;
//	}

	public int getId() {
		return getInt("id");
	}
	public void setId(int id) {
		this.put("id", id);
	}
	public int getPid() {
		return getInt("pid");
	}
	public void setPid(int pid) {
		this.put("pid", pid);
	}
	public int getNid() {
		return getInt("nid");
	}
	public void setNid(int nid) {
		this.put("nid", nid);
	}
	public String getConcsspath() {
		return getString("concsspath");
	}
	public void setConcsspath(String concsspath) {
		this.put("concsspath", concsspath);
	}
	public String getKeycsspath() {
		return getString("keycsspath");
	}
	public void setKeycsspath(String keycsspath) {
		this.put("keycsspath", keycsspath);
	}
	public int getRank() {
		return getInt("rank");
	}
	public void setRank(int rank) {
		this.put("rank", rank);
	}
	public String getReplacerule() {
		return getString("replacerule");
	}
	public void setReplacerule(String replacerule) {
		this.put("replacerule", replacerule);
	}
	public String getTesturl() {
		return getString("testurl");
	}
	public void setTesturl(String testurl) {
		this.put("testurl", testurl);
	}
	public int getUpdateuid() {
		return getInt("updateuid");
	}
	public void setUpdateuid(int updateuid) {
		this.put("updateuid", updateuid);
	}
	public String getRulename() {
		return getString("rulename");
	}
	public void setRulename(String rulename) {
		this.put("rulename", rulename);
	}
	public String getVideocsspath() {
		return getString("videocsspath");
	}
	public void setVideocsspath(String videocsspath) {
		this.put("videocsspath", videocsspath);;
	}
	public String getAuthorcsspath() {
		return getString("authorcsspath");
	}
	public void setAuthorcsspath(String authorcsspath) {
		this.put("authorcsspath", authorcsspath);
	}
	public String getCommentcssapth() {
		return getString("commentcssapth");
	}
	public void setCommentcssapth(String commentcssapth) {
		this.put("commentcssapth", commentcssapth);
	}
	public String getConcsspath1() {
		return getString("concsspath1");
	}
	public void setConcsspath1(String concsspath1) {
		this.put("concsspath1", concsspath1);
	}
	public String getConcsspath2() {
		return getString("concsspath2");
	}
	public void setConcsspath2(String concsspath2) {
		this.put("concsspath2", concsspath2);
	}
	public String getReplacecsspath() {
		return getString("replacecsspath");
	}
	public void setReplacecsspath(String replacecsspath) {
		this.put("replacecsspath", replacecsspath);
	}


    @Override
    public String toString() {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("id", this.getInt("id"));
        result.put("pid", this.getInt("pid"));
        result.put("nid", this.getInt("nid"));
        result.put("rulename", this.getString("rulename"));
        result.put("concsspath", this.getString("concsspath"));
        result.put("concsspath1", this.getString("concsspath1"));
        result.put("concsspath2", this.getString("concsspath2"));
        result.put("keycsspath", this.getString("keycsspath"));
        result.put("videocsspath", this.getString("videocsspath"));
        result.put("authorcsspath", this.getString("authorcsspath"));
        result.put("commentcssapth", this.getString("commentcssapth"));
        result.put("replacecsspath", this.getString("replacecsspath"));
        result.put("rank", this.getInt("rank"));
        result.put("replacerule", this.getString("replacerule"));
        result.put("testurl", this.getString("testurl"));
        result.put("updateuid", this.getInt("updateuid"));
        result.put("objectId", this.getObjectId());
        result.put("createdAt", this.getCreatedAt());
        return JSON.toJSONString(result);
    }
	
	
	
	

}
