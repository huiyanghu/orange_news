package com.it7890.orange.manage.dao.impl;

import com.it7890.orange.manage.dao.ArticleManagerRuleDao;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/5/15.
 */
@Component
public class ArticleManagerRuleDaoImpl implements ArticleManagerRuleDao {
/*
    @Override
    public List<ConGrabCRule> getAll() {
        List<ConGrabCRule> list = new ArrayList<ConGrabCRule>();
        AVCloudQueryResult result;
        try {
            String cql = "select * from con_grab_crule where status!=-1";
            result = AVQuery.doCloudQuery(cql, ConGrabCRule.class);
            list = (List<ConGrabCRule>) result.getResults();
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public List<ConGrabCRule> getSelect(ConGrabCRule bean) {
        List<ConGrabCRule> list = new ArrayList<ConGrabCRule>();
        AVCloudQueryResult result;
        try {
            StringBuffer sb = new StringBuffer();
            sb.append("select * from con_grab_crule where status!=-1");
            if (bean.getRulename() != null && !"".equals(bean.getRulename())) {
                sb.append(" and rulename like '%" + bean.getRulename() + "%' ");
            }
            if (bean.getStatus() != -1) {
                sb.append(" and status=" + bean.getStatus());
            }
            String cql = sb.toString();
            System.out.println(cql);
            result = AVQuery.doCloudQuery(cql, ConGrabCRule.class);
            list = (List<ConGrabCRule>) result.getResults();
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public ConGrabCRule getContentById(String objectId) {
        ConGrabCRule object = null;
        List<ConGrabCRule> list = new ArrayList<>();
        AVCloudQueryResult result;
        try {
            String cql = " select * from con_grab_crule where objectId = ?";
            result = AVQuery.doCloudQuery(cql, ConGrabCRule.class, objectId);
            list = (List<ConGrabCRule>) result.getResults();
            object = list.get(0);
        } catch (Exception e) {
        }
        return object;
    }

    //TODO 文章规则修改删除未完成
    @Override
    public String insertConRule(ConGrabCRule bean) {
        String objectId = "";
        try {
            AVObject todoFolder = new AVObject("con_grab_crule");// 构建对象
            todoFolder.put("id", bean.getId());
            todoFolder.put("status", bean.getStatus());
            todoFolder.put("rulename", bean.getRulename());
            todoFolder.put("descsspath", bean.getDescsspath());
            todoFolder.put("keycsspath", bean.getKeycsspath());
            todoFolder.put("concsspath", bean.getConcsspath());
            todoFolder.put("concsspath1", bean.getConcsspath1());
            todoFolder.put("concsspath2", bean.getConcsspath2());
            todoFolder.put("soucsspath", bean.getSoucsspath());
            todoFolder.put("imgcsspath", bean.getImgcsspath());
            todoFolder.put("videocsspath", bean.getVideocsspath());
            todoFolder.put("authorcsspath", bean.getAuthorcsspath());
            todoFolder.put("lid", bean.getLid());
            todoFolder.put("nodeid", bean.getNodeid());
            todoFolder.put("testurl", bean.getTesturl());
            todoFolder.put("constatus", bean.getConstatus());
            todoFolder.put("topic", bean.getTopic());
            todoFolder.put("replacerule", bean.getReplacerule());
            todoFolder.put("replacecsspath", bean.getReplacecsspath());
            todoFolder.put("titlecsspath", bean.getTitlecsspath());
            todoFolder.put("channelid", bean.getChannelid());
            todoFolder.save();
            objectId = todoFolder.getObjectId();
        } catch (AVException e) {
        }
        return objectId;
    }

    @Override
    public String updateConRule(ConGrabCRule bean) {
        try {
            // 第一参数是 className,第二个参数是 objectId
            AVObject todoFolder = AVObject.createWithoutData("con_grab_crule", bean.getObjectId());
            todoFolder.put("id", bean.getId());
            todoFolder.put("status", bean.getStatus());
            todoFolder.put("rulename", bean.getRulename());
            todoFolder.put("descsspath", bean.getDescsspath());
            todoFolder.put("keycsspath", bean.getKeycsspath());
            todoFolder.put("concsspath", bean.getConcsspath());
            todoFolder.put("concsspath1", bean.getConcsspath1());
            todoFolder.put("concsspath2", bean.getConcsspath2());
            todoFolder.put("soucsspath", bean.getSoucsspath());
            todoFolder.put("imgcsspath", bean.getImgcsspath());
            todoFolder.put("videocsspath", bean.getVideocsspath());
            todoFolder.put("authorcsspath", bean.getAuthorcsspath());
            todoFolder.put("lid", bean.getLid());
            todoFolder.put("nodeid", bean.getNodeid());
            todoFolder.put("testurl", bean.getTesturl());
            todoFolder.put("constatus", bean.getConstatus());
            todoFolder.put("topic", bean.getTopic());
            todoFolder.put("replacerule", bean.getReplacerule());
            todoFolder.put("replacecsspath", bean.getReplacecsspath());
            todoFolder.put("titlecsspath", bean.getTitlecsspath());
            todoFolder.put("channelid", bean.getChannelid());
            todoFolder.save();
            String objectId = todoFolder.getObjectId();
        } catch (AVException e) {
        }
        return null;
    }

    @Override   //删除
    public void deleteRuleByObjectId(String id) {
        try {
            // 第一参数是 className,第二个参数是 objectId
            AVObject todoFolder = AVObject.createWithoutData("con_grab_crule", id);
            todoFolder.put("status", -1);
            todoFolder.save();
            String objectId = todoFolder.getObjectId();
        } catch (AVException e) {
        }
    }


    @Override
    public List<ConGrabCRule> getAllConByLid(Integer id) {
        List<ConGrabCRule> list = new ArrayList<ConGrabCRule>();
        AVCloudQueryResult result;
        try {
            String cql = "select * from con_grab_crule where lid=" + id;
            result = AVQuery.doCloudQuery(cql, ConGrabCRule.class);
            list = (List<ConGrabCRule>) result.getResults();
        } catch (Exception e) {
        }
        return list;
    }*/
}
