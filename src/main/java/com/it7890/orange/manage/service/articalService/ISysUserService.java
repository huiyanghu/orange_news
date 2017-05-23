package com.it7890.orange.manage.service.articalService;

import com.it7890.orange.manage.model.SysUser;

import java.util.List;


/**
 * @ClassName: ISysuserService
 * @Description: 
 * @author zhoujie@7890it.com
 * @date 2015年10月17日 上午9:35:50
 */
public interface ISysUserService {
	
	SysUser login(String user, String pass);

	List<SysUser> getUserListByPage(SysUser sysuser);
	
	List<SysUser> getAllSysUser();
	
	SysUser selectByPrimaryKey(Integer userid);
	
	int update(SysUser sysuser);
	
	int add(SysUser sysuser);
	
	int delete(int userid);
	
	SysUser getByUsername(String username);

	int insertUser(SysUser user);
}
