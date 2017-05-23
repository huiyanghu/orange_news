package com.it7890.orange.manage.service.articalService;

import com.it7890.orange.manage.model.AppPushInfo;
import com.it7890.orange.manage.model.ConArticle;
import com.it7890.orange.manage.model.GlobalNode;
import com.it7890.orange.manage.utils.PageUtil;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @date 2015年11月12日 下午2:36:03
 */
public interface IConArticleService {


    List<ConArticle> getAllConArticle();

    int insertConArticle(ConArticle conarticle);

    int updateConArticle(ConArticle conarticle);

    int deleteConArticle(int id);

    ConArticle getConArticleById(int id);

    //List<ConArticle> getArticleByPage(ConArticle article, PageBounds pagebounds);

    List<ConArticle> getConarticleByCtype(int ctype);

    int insertAppPushInfo(AppPushInfo pushInfo);

    int updateAppPushInfo(AppPushInfo pushInfo);

    AppPushInfo getAppPushInfoByArticleid(String articleid);

    //List<ArticleAndPushInfo> getArticleAndPushInfoByPage(AppPushInfo apppushinfo, PageBounds pagebounds);

    AppPushInfo getAppPushInfoByarticleId(String articleid);

    public List<ConArticle> getarticlelist(ConArticle article, PageUtil pageUtil);

    public long articletotal(ConArticle article);

    public List<ConArticle> getarticlelistforpushinfo(ConArticle article, PageUtil pageUtil);

    public long totalforpushinfo(ConArticle article);

    public List<ConArticle> getarticleByid(int id);

    public long articlecountBycountryid(String countrycode);

    public long monthcountBycountryid(String countrycode);

    ConArticle getArticleByarticleid(String articleid);

    public Map<String, Long> publicationStatisticList(String countrycode);

    long updateConArticleES(ConArticle conarticle);

    long deleteConArticleES(int id);

    ConArticle getConArticleByIdES(int id);

    long deleteConArticleListES(String ids);

    long passConArticleListES(String ids);

    List<ConArticle> getConArticleByIdsES(String ids);

    public Map<String, Long> publicationStatisticListByWhere(String countrycode, String starttime, String endtime);

    /***
     * 后台提供各个国家下的各个分类抓取数量的总表,以天为单位
     * @return
     */
    Map<String, Map<String, Long>> getClassifiedConArticle(String createtime);
}
