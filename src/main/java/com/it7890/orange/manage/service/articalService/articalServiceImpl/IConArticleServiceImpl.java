package com.it7890.orange.manage.service.articalService.articalServiceImpl;

import com.avos.avoscloud.AVCloudQueryResult;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.it7890.orange.manage.model.AppPushInfo;
import com.it7890.orange.manage.model.ConArticle;
import com.it7890.orange.manage.model.GlobalNode;
import com.it7890.orange.manage.service.articalService.IConArticleService;
import com.it7890.orange.manage.utils.PageUtil;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by yt on 2017/5/23.
 */

@Component
public class IConArticleServiceImpl implements IConArticleService {
    @Override
    public List<ConArticle> getAllConArticle() {
        return null;
    }

    @Override
    public int insertConArticle(ConArticle conarticle) {
        return 0;
    }

    @Override
    public int updateConArticle(ConArticle conarticle) {
        return 0;
    }

    @Override
    public int deleteConArticle(int id) {
        return 0;
    }

    @Override
    public ConArticle getConArticleById(int id) {
        return null;
    }

    @Override
    public List<ConArticle> getConarticleByCtype(int ctype) {
        return null;
    }

    @Override
    public int insertAppPushInfo(AppPushInfo pushInfo) {
        return 0;
    }

    @Override
    public int updateAppPushInfo(AppPushInfo pushInfo) {
        return 0;
    }

    @Override
    public AppPushInfo getAppPushInfoByArticleid(String articleid) {
        return null;
    }

    @Override
    public AppPushInfo getAppPushInfoByarticleId(String articleid) {
        return null;
    }

    @Override
    public List<ConArticle> getarticlelist(ConArticle article, PageUtil pageUtil) {
        List<ConArticle> list = new ArrayList<ConArticle>();
        AVQuery<ConArticle> avQuery = new AVQuery<>("conarticle");
        AVCloudQueryResult result;
  /*      String cql = "";
        try {
            result = AVQuery.doCloudQuery(cql, ConArticle.class);
            list = (List<ConArticle>) result.getResults();
        } catch (Exception e) {
        }*/
        // 查询条件
        if (article.getAuthor() != null || article.getStatus() >= 0 || article.getCountrycode() != null || article.getKeywords() != null ||
            article.getTopicsid() > 0 || article.getStarttime() != null || article.getEndtime() != null || article.getPublicationid() > 0
            || article.getLangid() != null || article.getId() > 0 || article.getChannelid() > 0 || article.getAttr() >= 0) {
            if (article.getId() > 0) {
                avQuery.whereEqualTo("objectId", article.getId());
            }
            if (article.getAuthor() != null) {
                avQuery.whereEqualTo("author", article.getAuthor());
            }
            if (article.getStatus() >= 0) {
                avQuery.whereEqualTo("status", article.getStatus());
            }
            if (article.getCountrycode() != null) {
                avQuery.whereEqualTo("countrycode", article.getCountrycode());
            }
            if (article.getKeywords() != null) {
                avQuery.whereEqualTo("keyword", article.getKeywords());
            }
            if (article.getTopicsid() > 0) {
                avQuery.whereEqualTo("topicObj", article.getTopicsid());
            }
            if (article.getStarttime() != null) {
            }
            if (article.getEndtime() != null) {
            }
            if (article.getPublicationid() > 0) {// 媒体列表查看每个媒体下的文章
                avQuery.whereEqualTo("publicationObj", article.getPublicationid());
            }
            if (article.getChannelid() > 0) {
            }
            if (article.getLangid() != null && !article.getLangid().equals("")) {
                avQuery.whereEqualTo("langid", article.getLangid());
            }
            if (article.getAttr() >= 0) {
            }
            avQuery.limit(pageUtil.getPageSize());
            avQuery.skip((pageUtil.getCurrentPage() - 1) * pageUtil.getPageSize());
            try {
                list = avQuery.find();
            } catch (AVException e) {
                e.printStackTrace();
            }
        } else {
        }
        return list;

    }

    @Override
    public long articletotal(ConArticle article) {
        AVCloudQueryResult result;
        String cql = "select count(*) from conarticle";
        int count = 0;
        try {
            result = AVQuery.doCloudQuery(cql, ConArticle.class);
            count = result.getCount();
        } catch (Exception e) {
        }
        return count;
    }

    @Override
    public List<ConArticle> getarticlelistforpushinfo(ConArticle article, PageUtil pageUtil) {
        return null;
    }

    @Override
    public long totalforpushinfo(ConArticle article) {
        return 0;
    }

    @Override
    public List<ConArticle> getarticleByid(int id) {
        return null;
    }

    @Override
    public long articlecountBycountryid(String countrycode) {
        return 0;
    }

    @Override
    public long monthcountBycountryid(String countrycode) {
        return 0;
    }

    @Override
    public ConArticle getArticleByarticleid(String articleid) {
        return null;
    }

    @Override
    public Map<String, Long> publicationStatisticList(String countrycode) {
        return null;
    }

    @Override
    public long updateConArticleES(ConArticle conarticle) {
        return 0;
    }

    @Override
    public long deleteConArticleES(int id) {
        return 0;
    }

    @Override
    public ConArticle getConArticleByIdES(int id) {
        return null;
    }

    @Override
    public long deleteConArticleListES(String ids) {
        return 0;
    }

    @Override
    public long passConArticleListES(String ids) {
        return 0;
    }

    @Override
    public List<ConArticle> getConArticleByIdsES(String ids) {
        return null;
    }

    @Override
    public Map<String, Long> publicationStatisticListByWhere(String countrycode, String starttime, String endtime) {
        return null;
    }

    @Override
    public Map<String, Map<String, Long>> getClassifiedConArticle(String createtime) {
        return null;
    }
}
