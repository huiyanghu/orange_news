package com.it7890.orange.manage.dao;

import com.it7890.orange.manage.model.ConGrabLRule;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListManagerRuleDao {

    //列表
    List<ConGrabLRule> getAll();

    ConGrabLRule getLRuleById(String objectId);

    String insert(ConGrabLRule bean);

    void update(ConGrabLRule bean);

    void deleteRuleByObjectId(String objectId);

	/*

	@Select("select * from con_grab_lrule where id=#{id}")
	ConGrabLRule getById(int id);
	
	@Insert("insert into con_grab_lrule (pid,rulename,nodeid,channelid,csspath,createtime,url,code,langid,status,topic,grabtime,findpre,liststatus,constant) "
			+"values (#{pid},#{rulename},#{nodeid},#{channelid},#{csspath},#{createtime},#{url},#{code},#{langid},#{status},#{topic},#{grabtime},#{findpre},#{liststatus},#{constant})")
	int insert(ConGrabLRule bean);
	
	@Update("update con_grab_lrule set pid=#{pid},rulename=#{rulename},nodeid=#{nodeid},channelid=#{channelid},csspath=#{csspath},createtime=#{createtime},url=#{url},code=#{code},langid=#{langid},status=#{status},grabtime=#{grabtime},topic=#{topic},findpre=#{findpre},liststatus=#{liststatus},constant=#{constant} where id=#{id}")
	int update(ConGrabLRule bean);

	@Select("select count(*) from con_grab_lrule where status!=-1")
	int countPage();
	
	@Select("select * from con_grab_lrule where channelid=#{channelid} or nodeid=#{nodeid} or pid=#{pid} or topic=#{topic}")
	List<ConGrabLRule> getAllByCondition(@Param("channelid") int channelid, @Param("nodeid") int nodeid, @Param("pid") int pid, @Param("topicid") int topicid);
	
	@SelectProvider(type = ConGrabListSqlProvider.class,  method = "getListBywhere")
	List<ConGrabLRule> LikeSearch(String search);
	
	@Select("select * from global_node")
	List<GlobalNode> getAllNodes();
	
	@Select("select * from con_channel")
	List<ConChannel> getChannellist();
	
	@Select("select * from con_publications where name is not  null and name!='' order by name")
	List<ConPublication> getPublications();
	
	@Select("select * from con_grab_lrule where nodeid=#{nodeid} and status=0")
	List<ConGrabLRule> getAllByNodeid(int nodeid);
	
	//内容
	@Select("select * from con_grab_crule where id=#{id}")
	ConGrabCRule getContentById(int id);
	
	@Select("select * from con_grab_crule where status!=-1")
	List<ConGrabCRule> getAllContent();
	
	@Insert("insert into con_grab_crule (rulename,nodeid,titlecsspath,descsspath,concsspath,concsspath1,concsspath2"
	+",soucsspath,imgcsspath,videocsspath,authorcsspath,keycsspath,testurl,replacerule,replacecsspath,topic,lid) values (#{rulename},#{nodeid},#{titlecsspath}"
	+",#{descsspath},#{concsspath},#{concsspath1},#{concsspath2}"
	+",#{soucsspath},#{imgcsspath},#{videocsspath},#{authorcsspath},#{keycsspath},#{testurl},#{replacerule},#{replacecsspath}"
	+",#{topic},#{lid})")
	int insertConRule(ConGrabCRule bean);
	
	@Update("update con_grab_crule set titlecsspath=#{titlecsspath},rulename=#{rulename},constatus=#{constatus},status=#{status}"
	+",descsspath=#{descsspath},keycsspath=#{keycsspath},concsspath=#{concsspath},concsspath1=#{concsspath1},concsspath2=#{concsspath2}"
	+",soucsspath=#{soucsspath},imgcsspath=#{imgcsspath},videocsspath=#{videocsspath},authorcsspath=#{authorcsspath},lid=#{lid},nodeid=#{nodeid},testurl=#{testurl}"
	+",topic=#{topic},replacerule=#{replacerule},replacecsspath=#{replacecsspath} where id=#{id}")
	int updateConRule(ConGrabCRule bean);
	
	@Update("update con_grab_crule set status=-1 where id=#{id}")
	int delete(Integer id);
	
	@Select("select count(*) from con_grab_crule where status=0")
	int countConPage();
	
	@SelectProvider(type = ConGrabListSqlProvider.class,  method = "getConListBywhere")
	List<ConGrabCRule> LikeConSearch(String search);
	
	@Select("select * from con_grab_crule where nodeid=#{nodeid}")
	List<ConGrabCRule> getAllConByNodeid(int nodeid);
	
	@Select("select * from con_grab_crule where lid=#{lid} and status!=-1")
	List<ConGrabCRule> getAllConByLid(int lid);
	
	@Select("select * from con_grab_crule where status=0 and constatus=#{constatus}")
	List<ConGrabCRule> getAllPrepareCon(int constatus);
	
	@SelectProvider(type = ConGrabListSqlProvider.class,  method = "getListLPage")
	List<ConGrabLRule> getListLPage(ConGrabLRule bean, PageBounds pageBounds);

	@SelectProvider(type = ConGrabListSqlProvider.class,  method = "getListCPage")
	List<ConGrabCRule> getListCPage(ConGrabCRule bean, PageBounds pageBounds);

	@Select("SELECT DISTINCT code, topic from con_grab_lrule where code=#{code}")
	List<Map<String,Object>> getTopicListByCountry(@Param("code") String code);
	*/
}

