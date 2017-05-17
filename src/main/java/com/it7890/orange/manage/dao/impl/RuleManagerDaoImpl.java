package com.it7890.orange.manage.dao.impl;

import com.it7890.orange.manage.dao.RuleManagerDao;
import com.it7890.orange.manage.model.GlobalRule;
import com.avos.avoscloud.AVCloudQueryResult;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/15.
 */
@Component
public class RuleManagerDaoImpl implements RuleManagerDao {
    @Override
    public List<GlobalRule> getAll() {
        List<GlobalRule> list = new ArrayList<GlobalRule>();
        AVCloudQueryResult result;
        try {
            String cql = "select * from GlobalRule";
            result = AVQuery.doCloudQuery(cql, GlobalRule.class);
            list = (List<GlobalRule>) result.getResults();
        } catch (Exception e) {
        }
        return list;
    }

    //根据id获取对象
    @Override
    public GlobalRule getById(String objectId) {
        GlobalRule object = null;
        List<GlobalRule> list = new ArrayList<>();
        AVCloudQueryResult result;
        try {
            String cql = " select * from GlobalRule where objectId = ?";
            result = AVQuery.doCloudQuery(cql, GlobalRule.class, objectId);
            list = (List<GlobalRule>)result.getResults();
            object = list.get(0);
        } catch (Exception e) {
        }
        return object;
    }

    //添加
    @Override
    public String insert(GlobalRule bean) {
        String objectId = "";
        try {
            AVObject todoFolder = new AVObject("GlobalRule");// 构建对象
            todoFolder.put("id", bean.getId());
            todoFolder.put("pid", bean.getPid());
            todoFolder.put("nid", bean.getNid());
            todoFolder.put("rulename", bean.getRulename());
            todoFolder.put("concsspath", bean.getConcsspath());
            todoFolder.put("concsspath1", bean.getConcsspath1());
            todoFolder.put("concsspath2", bean.getConcsspath2());
            todoFolder.put("keycsspath", bean.getKeycsspath());
            todoFolder.put("videocsspath", bean.getVideocsspath());
            todoFolder.put("authorcsspath", bean.getAuthorcsspath());
            todoFolder.put("commentcssapth", bean.getCommentcssapth());
            todoFolder.put("replacecsspath", bean.getReplacecsspath());
            todoFolder.put("rank", bean.getRank());
            todoFolder.put("replacerule", bean.getReplacerule());
            todoFolder.put("testurl", bean.getTesturl());
            todoFolder.put("updateuid", bean.getUpdateuid());
            todoFolder.save();
            objectId = todoFolder.getObjectId();
        } catch (AVException e) {
        }
        return objectId;
    }

    ///更新 TODO 添加更新未完成
    @Override
    public String update(GlobalRule bean) {
        try {
            // 第一参数是 className,第二个参数是 objectId
            AVObject todoFolder = AVObject.createWithoutData("GlobalRule", bean.getObjectId());
            todoFolder.put("id", bean.getId());
            todoFolder.put("pid", bean.getPid());
            todoFolder.put("nid", bean.getNid());
            todoFolder.put("rulename", bean.getRulename());
            todoFolder.put("concsspath", bean.getConcsspath());
            todoFolder.put("concsspath1", bean.getConcsspath1());
            todoFolder.put("concsspath2", bean.getConcsspath2());
            todoFolder.put("keycsspath", bean.getKeycsspath());
            todoFolder.put("videocsspath", bean.getVideocsspath());
            todoFolder.put("authorcsspath", bean.getAuthorcsspath());
            todoFolder.put("commentcssapth", bean.getCommentcssapth());
            todoFolder.put("replacecsspath", bean.getReplacecsspath());
            todoFolder.put("rank", bean.getRank());
            todoFolder.put("replacerule", bean.getReplacerule());
            todoFolder.put("testurl", bean.getTesturl());
            todoFolder.put("updateuid", bean.getUpdateuid());
            // 保存到云端
            todoFolder.save();
            String objectId = todoFolder.getObjectId();
        } catch (AVException e) {
        }
        return null;
    }

    //删除
    @Override
    public void deleteRuleByObjectId(String objectId) {
        try {
            // 第一参数是 className,第二个参数是 objectId
            AVObject todo = AVObject.createWithoutData("GlobalRule", objectId);
            todo.delete();
        } catch (AVException e) {
        }
    }
}
