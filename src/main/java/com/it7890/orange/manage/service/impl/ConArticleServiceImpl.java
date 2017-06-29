package com.it7890.orange.manage.service.impl;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.it7890.orange.manage.dao.ConArticleDao;
import com.it7890.orange.manage.model.ConArticle;
import com.it7890.orange.manage.po.ConArticleQuery;
import com.it7890.orange.manage.service.ConArticleService;
import com.it7890.orange.manage.vo.ConArticleDTO;
import com.it7890.orange.manage.vo.ConArticleDetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/31.
 */
@Service
public class ConArticleServiceImpl implements ConArticleService {
    @Autowired
    private ConArticleDao conArticleDao;

    public Map getAll(ConArticleQuery conArticleQuery, Integer page) throws AVException {
        return conArticleDao.getAll(conArticleQuery, page);
    }

    public List<ConArticle> get(ConArticleQuery conArticleQuery) throws AVException {
        return conArticleDao.get(conArticleQuery);
    }

    public ConArticle getById(String objectId) throws AVException {
        return conArticleDao.getById(objectId);
    }

    public void deleteBatch(String ids) throws AVException {
        String[] idArr = ids.split(",");
        for (String id : idArr) {
            ConArticle article = conArticleDao.getById(id);
            article.setStatus(-1);
            article.save();
        }

    }

    public void publishBatch(String ids) throws AVException {
        String[] idArr = ids.split(",");
        for (String id : idArr) {
            conArticleDao.publish(id);
        }
    }

    @Override
    public ConArticleDetailDTO getContentByArtID(String artId) throws IOException, AVException {
        AVObject avo = conArticleDao.getByArtid(artId);
        return ConArticleDetailDTO.objectToDto(avo);
    }

    @Override
    public ConArticleDTO getConarticleById(String artid) throws AVException {
        return ConArticleDTO.avobjectToDto(conArticleDao.getConarticleByid(artid));
    }


}
