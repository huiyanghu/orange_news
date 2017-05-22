package com.it7890.orange.manage.dao.impl;

import com.avos.avoscloud.AVCloudQueryResult;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.it7890.orange.manage.dao.ListManagerRuleDao;
import com.it7890.orange.manage.model.ConGrabLRule;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/11.
 */
@Component
public class ListManagerRuleDaoImpl implements ListManagerRuleDao {
    @Override
    public List<ConGrabLRule> getAll() {
        List<ConGrabLRule> list = new ArrayList<>();
        AVCloudQueryResult result;
        try {
            String cql = "select * from con_grab_lrule where status = 1";
            result = AVQuery.doCloudQuery(cql, ConGrabLRule.class);
            list = (List<ConGrabLRule>) result.getResults();
        } catch (Exception e) {
        }
        return list;
    }

    //查询
    @Override
    public List<ConGrabLRule> getSelect(ConGrabLRule bean) {
        List<ConGrabLRule> list = new ArrayList<ConGrabLRule>();
        AVCloudQueryResult result;
        try {
            StringBuffer sb = new StringBuffer();
            sb.append("select * from con_grab_lrule where status = 1");
            if (bean.getNodeid() != 0) {
                sb.append(" and nodeid =" + bean.getNodeid());
            }
            if (bean.getTopic() != 0) {
                sb.append(" and topic =" + bean.getTopic());
            }
            if (bean.getPid() != 0) {
                sb.append(" and pid =" + bean.getPid());
            }
            if (bean.getChannelid() != 0) {
                sb.append(" and channelid =" + bean.getChannelid());
            }
            if (bean.getRulename() != null && !"".equals(bean.getRulename())) {
                sb.append(" and rulename like '%" + bean.getRulename() + "%' ");
            }
            if (bean.getCountryCode() != null && !"".equals(bean.getCountryCode())) {
                sb.append(" and code like '%" + bean.getCountryCode() + "%' ");
            }
//            sb.append(" order by id desc");
            String cql = sb.toString();
//            System.out.println(cql);
//            String cql = "select * from con_grab_lrule where pid = ? and channelid=? and topic=? and countryCode=? and rulename like ?";
            result = AVQuery.doCloudQuery(cql, ConGrabLRule.class );
            list = (List<ConGrabLRule>) result.getResults();
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public ConGrabLRule getLRuleById(String objectId) {
        ConGrabLRule object = null;
        List<ConGrabLRule> list = new ArrayList<>();
        AVCloudQueryResult result;
        try {
            String cql = " select * from con_grab_lrule where objectId = ?";
            result = AVQuery.doCloudQuery(cql, ConGrabLRule.class, objectId);
            list = (List<ConGrabLRule>) result.getResults();
//            AVQuery<AVObject> avQuery = new AVQuery<>("con_grab_lrule");
            object = list.get(0);
        } catch (Exception e) {
        }
        return object;
    }

    @Override
    public String insert(ConGrabLRule bean) {
        String objectId = "";
        try {
            AVObject todoFolder = new AVObject("con_grab_lrule");// 构建对象
            todoFolder.put("id", bean.getId());
            todoFolder.put("pid", bean.getPid());
            todoFolder.put("rulename", bean.getRulename());
            todoFolder.put("nodeid", bean.getNodeid());
            todoFolder.put("channelid", bean.getChannelid());
            todoFolder.put("csspath", bean.getCsspath());
            todoFolder.put("url", bean.getUrl());
            todoFolder.put("url", bean.getUrl());
            todoFolder.put("code", bean.getCountryCode());
            todoFolder.put("langid", bean.getLangid());
            todoFolder.put("grabtime", bean.getGrabtime());
            todoFolder.put("topic", bean.getTopic());
//            todoFolder.put("status", bean.getStatus());
            todoFolder.put("constant", bean.getConstant());
//            todoFolder.put("mistakeurl", bean.getMistakeurl());
            todoFolder.put("liststatus", bean.getListstatus());
            todoFolder.put("findpre", bean.getFindpre());
            todoFolder.save();
            objectId = todoFolder.getObjectId();
        } catch (AVException e) {

        }
        return objectId;
    }

    //TODO 列表规则修改删除未完成
    @Override
    public void update(ConGrabLRule bean) {
        try {
//            bean.delete();
            // 第一参数是 className,第二个参数是 objectId
            AVObject todo = AVObject.createWithoutData("con_grab_lrule", bean.getObjectId());
            todo.put("id", bean.getId());
            todo.put("pid", bean.getPid());
            todo.put("rulename", bean.getRulename());
            todo.put("nodeid", bean.getNodeid());
            todo.put("channelid", bean.getChannelid());
            todo.put("csspath", bean.getCsspath());
            todo.put("url", bean.getUrl());
            todo.put("url", bean.getUrl());
            todo.put("code", bean.getCountryCode());
            todo.put("langid", bean.getLangid());
            todo.put("grabtime", bean.getGrabtime());
            todo.put("topic", bean.getTopic());
            todo.put("status", bean.getStatus());
            todo.put("constant", bean.getConstant());
//            ttodo.put("mistakeurl", bean.getMistakeurl());
            todo.put("liststatus", bean.getListstatus());
            todo.put("findpre", bean.getFindpre());
            // 保存到云端
            todo.save();
            String objectId = todo.getObjectId();
        } catch (AVException e) {
        }
    }

    //删除
    @Override
    public void deleteRuleByObjectId(String objectId) {
        try {
            // 第一参数是 className,第二个参数是 objectId
            AVObject todo = AVObject.createWithoutData("con_grab_lrule", objectId);
            todo.put("status", 0);
            todo.save();
        } catch (AVException e) {
        }

    }
}
