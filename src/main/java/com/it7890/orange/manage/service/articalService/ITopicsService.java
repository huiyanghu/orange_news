package com.it7890.orange.manage.service.articalService;

import com.it7890.orange.manage.model.AppTopics;
import com.it7890.orange.manage.model.HbTopics;

import java.util.List;


/**
 * @ClassName: ITopicsService
 * @Description: 
 * @author zhoujie@7890it.com
 * @date 2015年10月15日 下午6:48:58
 */
public interface ITopicsService {
	
	public List<HbTopics> getAllHbTopics();

	public List<AppTopics> getAppTopicsById(int countryid);

	public HbTopics getAppTopicsByid(int tid);

	public int insertHbTopics(HbTopics topics);

	public int updateHbTopics(HbTopics topics);
	
	public int delete(int tid); 
	
	public int deleteAppTopics(int topicid);
	
	public int updateAppTopics(AppTopics apptopics);

	int updateCountryTopics(int topicid, List<AppTopics> delapptics, List<AppTopics> addapptics, List<AppTopics> updateapptopics);

	public HbTopics getHbTopicsBytid(int i);
	
	//List<HbTopics> getTopicByPage(HbTopics topic, PageBounds pagebounds);
	
	 //List<AppTopics> getAppTopicsByTopicId(@Param("topicid") int topicid);
	
	int insert(AppTopics apptopics);
	
	int updateApptopicsBytidAdnCountryid(AppTopics apptopics);
	
	List<HbTopics> getAllHbTopicsBytopicType(int topictype);
}
