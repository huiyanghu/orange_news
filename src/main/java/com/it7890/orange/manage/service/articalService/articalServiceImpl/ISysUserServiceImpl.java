package com.it7890.orange.manage.service.articalService.articalServiceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.it7890.orange.manage.model.ConPublication;
import com.it7890.orange.manage.model.SysUser;
import com.it7890.orange.manage.service.articalService.ISysUserService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @date 2015年10月18日 下午5:32:51
 */
@Service
public class ISysUserServiceImpl implements ISysUserService {


    @Override
    public SysUser login(String user, String pass) {
        return null;
    }

    @Override
    public List<SysUser> getUserListByPage(SysUser sysuser) {
        return null;
    }

    @Override
    public List<SysUser> getAllSysUser() {
        List<SysUser> list = new ArrayList<SysUser>();
        AVQuery<SysUser> query = AVObject.getQuery(SysUser.class);
        try {
            list = query.find();
        } catch (AVException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public SysUser selectByPrimaryKey(Integer userid) {
        return null;
    }

    @Override
    public int update(SysUser sysuser) {
        return 0;
    }

    @Override
    public int add(SysUser sysuser) {
        return 0;
    }

    @Override
    public int delete(int userid) {
        return 0;
    }

    @Override
    public SysUser getByUsername(String username) {
        return null;
    }

    @Override
    public int insertUser(SysUser user) {
        return 0;
    }
}
