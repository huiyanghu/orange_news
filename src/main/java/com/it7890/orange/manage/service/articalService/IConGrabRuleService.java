package com.it7890.orange.manage.service.articalService;

import com.it7890.orange.manage.model.ConArticle;
import com.it7890.orange.manage.model.ConGrabCRule;
import com.it7890.orange.manage.model.ConGrabLRule;
import com.it7890.orange.manage.utils.PageUtil;

import java.util.List;
import java.util.Map;


public interface IConGrabRuleService {

    //列表
    int insert(ConGrabLRule bean);

    int update(ConGrabLRule bean);

    List<ConGrabLRule> getAll();

    ConGrabLRule getById(Integer id);

    //	//根据媒体
//	List<ConGrabLRule> getAllByPid(int pid);
//	//根据渠道
//	List<ConGrabLRule> getAllByChannelid(int channelid);
//	//根据节点
    List<ConGrabLRule> getAllByNodeid(int nodeid);

    int countPage(ConGrabLRule bean);

    //List<ConGrabLRule>  getListLPage(ConGrabLRule bean, PageBounds pageBounds);

    List<ConGrabLRule> LikeSearch(String search);

    List<ConGrabLRule> getAllByCondition(int channelid, int nodeid, int publication, int topicid);

    List getAllNodes();

    List getChannellist();

    List getPublications();

    //内容
    ConGrabCRule getContentById(Integer id);

    List<ConGrabCRule> getAllContent();


    int insertConRule(ConGrabCRule bean);

    int updateConRule(ConGrabCRule bean);

    int countConPage(ConGrabCRule bean);

//	List<ConGrabCRule> getListCPage(ConGrabCRule bean, PageBounds pageBounds);

    int delete(Integer id);

    List<ConGrabCRule> LikeConSearch(String search);

    List<ConGrabCRule> getAllConByNodeid(int nodeid);

    List<ConGrabCRule> getAllConByLid(int lid);

    List<ConGrabCRule> getAllPrepareCon(int constatus);

    List<ConArticle> getAllEsArticleByChannelid(int channelid, PageUtil pageUtil);

    long conutArticle(int channelid);

    long updateConArticleES(ConArticle conarticle);

    ConArticle getConArticleByIdES(int id);

    //根据国家代码查询话题
    List<Map<String, Object>> getTopicListByCountry(String code);
}

















