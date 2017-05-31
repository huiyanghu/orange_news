package com.it7890.orange.manage.base.dao.impl;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.it7890.orange.manage.base.dao.BaseDao;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by Administrator on 2017/5/31.
 */
@Component("baseDao")
public abstract class BaseDaoImpl<E> implements BaseDao {

    /**
     * 为E对应的实例类型
     */
    //private Class<E> entityClass;
    private String avClassName;

    /**
     * 获取E实例类的类型
     */
    public BaseDaoImpl() {
        Class<?> c = this.getClass();
        Type t = c.getGenericSuperclass();
        if (t instanceof ParameterizedType) {
            Class<E> entityClass = (Class<E>) ((ParameterizedType) t).getActualTypeArguments()[0];
            avClassName=entityClass.getAnnotation(com.avos.avoscloud.AVClassName.class).value();
        }
    }

    /**
     * 软删除
     * @param objectId
     * @throws Exception
     */
    public void delete(String objectId) throws AVException{
        /**
         * 如果没有status列,会自动新增该列
         */
        AVObject avObject =this.getById(objectId);
        avObject.put("status", -1);
        avObject.save();
    }

    /**
     * 按id查询单个
     * @param objectId
     * @return
     * @throws AVException
     */
    public AVObject getById(String objectId) throws AVException{
        AVQuery<AVObject> query = new AVQuery<>(avClassName);
        AVObject avObject=query.get(objectId);
        return avObject;
    }
}
