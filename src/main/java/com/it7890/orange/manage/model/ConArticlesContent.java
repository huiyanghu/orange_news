package com.it7890.orange.manage.model;

import com.alibaba.fastjson.JSON;
import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;

import java.util.HashMap;
import java.util.Map;


/**
 * The persistent class for the con_articles_content database table.
 * 
 */
@AVClassName("con_articles_content")
public class ConArticlesContent extends AVObject {
	private static final long serialVersionUID = 1L;

    public ConArticlesContent() {
        super();
    }
	/*private int id;
	private String articleid;
	private String content;
	private int status;//用 于判断是插入还是更新文章内容*/

	public int getStatus() {
		return getInt("status");
	}

	public void setStatus(int status) {
		this.put("status", status);
	}

	public int getId() {
		return getInt("id");
	}

	public void setId(int id) {
		this.put("id", id);
	}

	public String getArticleid() {
		return getString("articleid");
	}

	public void setArticleid(String articleid) {
		this.put("articleid", articleid);
	}

	public String getContent() {
		return getString("content");
	}

	public void setContent(String content) {
		this.put("content", content);
	}

    @Override
    public String toString() {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("id", this.getInt("id"));
        result.put("articleid", this.getString("articleid"));
        result.put("content", this.getString("content"));
        result.put("status", this.getInt("status"));
        result.put("objectId", this.getObjectId());
        result.put("createdAt", this.getCreatedAt());
        return JSON.toJSONString(result);
    }

}