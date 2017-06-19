package com.it7890.orange.manage.vo;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVFile;
import com.avos.avoscloud.AVObject;
import com.it7890.orange.manage.utils.DateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class ConArticleDetailDTO {
	private static Logger logger = LogManager.getLogger(ConArticleDetailDTO.class);
	private String title;//标题
	private String country;//国家
	private String excerpt;//摘要
	private String copyright;//来源媒体
	private String copyrightId;//来源媒体id
	private String keywords;//检索词
	private String category;//目录
	private String categoryId;//话题Id
	private String contentBody;//文章内容
	private String pubTime;//发布时间
	private List titlePicList;//顶图

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getExcerpt() {
		return excerpt;
	}

	public void setExcerpt(String excerpt) {
		this.excerpt = excerpt;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getContentBody() {
		return contentBody;
	}

	public void setContentBody(String contentBody) {
		this.contentBody = contentBody;
	}

	public String getPubTime() {
		return pubTime;
	}

	public void setPubTime(String pubTime) {
		this.pubTime = pubTime;
	}

	public List getTitlePicList() {
		return titlePicList;
	}

	public void setTitlePicList(List titlePicList) {
		this.titlePicList = titlePicList;
	}
	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}


	public String getCopyrightId() {
		return copyrightId;
	}

	public void setCopyrightId(String copyrightId) {
		this.copyrightId = copyrightId;
	}

	public static ConArticleDetailDTO objectToDto(AVObject tmp) throws IOException, AVException {
		ConArticleDetailDTO conArticleDetailDTO = null;
		if(null != tmp) {
			conArticleDetailDTO = new ConArticleDetailDTO();
			conArticleDetailDTO.setTitle(tmp.getAVObject("articleObj").getString("title"));
			conArticleDetailDTO.setContentBody(URLEncoder.encode(tmp.getString("content"), "UTF-8"));
			conArticleDetailDTO.setCategory(tmp.getAVObject("articleObj").getAVObject("topicObj").getString("topicName"));
			conArticleDetailDTO.setCategoryId(tmp.getAVObject("articleObj").getAVObject("topicObj").getObjectId());
			conArticleDetailDTO.setCountry(tmp.getAVObject("articleObj").getString("countrycode"));
			conArticleDetailDTO.setPubTime(DateUtil.formatFromDate(DateUtil.FORMATER_YYYY_MM_DD_HH_MM_SS,tmp.getAVObject("articleObj").getCreatedAt().getTime()));
			if (tmp.getAVObject("articleObj").getAVObject("publicationObj")!=null){
				conArticleDetailDTO.setCopyright(tmp.getAVObject("articleObj").getAVObject("publicationObj").getString("name"));
				conArticleDetailDTO.setCopyrightId(tmp.getAVObject("articleObj").getAVObject("publicationObj").getObjectId());
			}
			List<AVFile> titlePics = tmp.getAVObject("articleObj").getList("titlePicObjArr");
			List<ImageInfoDTO> imageInfoDTOs = new ArrayList<>();
			if(titlePics!=null){
				imageInfoDTOs = ImageInfoDTO.buildImageInfoDTO(titlePics);
			}
			conArticleDetailDTO.setTitlePicList(imageInfoDTOs);
		}
		return conArticleDetailDTO;

	}
}
