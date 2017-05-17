package com.it7890.orange.manage.model;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;

import java.util.Date;

/**
 * @ClassName: HbCountry
 * @Description:
 * @author zhoujie@7890it.com
 * @date 2015年10月15日 下午3:25:35
 */
@AVClassName("")
public class AppCountrys  extends AVObject {

	private int id;
	private int countryid;
	private int allowcountryid;
	private String countryname;
	private String countrycode;
	private String countryicon;
	private int rank;

	private int createuid;
	private Date createtime;






	/**
	 * @return countrycode
	 * @author zhoujie@7890it.com
	 * @date 2015年10月16日 下午5:24:06
	*/
	public String getCountrycode() {
		return countrycode;
	}
	/**
	 * @param countrycode 要设置的 countrycode
	 * @author zhoujie@7890it.com
	 * @date 2015年10月16日 下午5:24:06
	*/
	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}
	/**
	 * @return countryicon
	 * @author zhoujie@7890it.com
	 * @date 2015年10月15日 下午5:35:28
	*/
	public String getCountryicon() {
		return countryicon;
	}
	/**
	 * @param countryicon 要设置的 countryicon
	 * @author zhoujie@7890it.com
	 * @date 2015年10月15日 下午5:35:28
	*/
	public void setCountryicon(String countryicon) {
		this.countryicon = countryicon;
	}
	/**
	 * @return countryname
	 * @author zhoujie@7890it.com
	 * @date 2015年10月15日 下午5:10:59
	*/
	public String getCountryname() {
		return countryname;
	}
	/**
	 * @param countryname 要设置的 countryname
	 * @author zhoujie@7890it.com
	 * @date 2015年10月15日 下午5:10:59
	*/
	public void setCountryname(String countryname) {
		this.countryname = countryname;
	}



	/**
	 * @return countryid
	 * @author zhoujie@7890it.com
	 * @date 2015年10月15日 下午5:10:25
	*/
	public int getCountryid() {
		return countryid;
	}
	/**
	 * @param countryid 要设置的 countryid
	 * @author zhoujie@7890it.com
	 * @date 2015年10月15日 下午5:10:25
	*/
	public void setCountryid(int countryid) {
		this.countryid = countryid;
	}
	/**
	 * @return allowcountryid
	 * @author zhoujie@7890it.com
	 * @date 2015年10月15日 下午5:10:25
	*/
	public int getAllowcountryid() {
		return allowcountryid;
	}
	/**
	 * @param allowcountryid 要设置的 allowcountryid
	 * @author zhoujie@7890it.com
	 * @date 2015年10月15日 下午5:10:25
	*/
	public void setAllowcountryid(int allowcountryid) {
		this.allowcountryid = allowcountryid;
	}
	/**
	 * @return createuid
	 * @author zhoujie@7890it.com
	 * @date 2015年10月15日 下午5:10:25
	*/
	public int getCreateuid() {
		return createuid;
	}
	/**
	 * @param createuid 要设置的 createuid
	 * @author zhoujie@7890it.com
	 * @date 2015年10月15日 下午5:10:25
	*/
	public void setCreateuid(int createuid) {
		this.createuid = createuid;
	}
	/**
	 * @return createtime
	 * @author zhoujie@7890it.com
	 * @date 2015年10月15日 下午5:10:25
	*/
	public Date getCreatetime() {
		return createtime;
	}
	/**
	 * @param createtime 要设置的 createtime
	 * @author zhoujie@7890it.com
	 * @date 2015年10月15日 下午5:10:25
	*/
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	/**
	 * @return id
	 * @author zhoujie@7890it.com
	 * @date 2015年10月15日 下午4:28:18
	*/
	public int getId() {
		return id;
	}
	/**
	 * @param id 要设置的 id
	 * @author zhoujie@7890it.com
	 * @date 2015年10月15日 下午4:28:18
	*/
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return rank
	 * @author zhoujie@7890it.com
	 * @date 2015年10月15日 下午4:28:18
	*/
	public int getRank() {
		return rank;
	}
	/**
	 * @param rank 要设置的 rank
	 * @author zhoujie@7890it.com
	 * @date 2015年10月15日 下午4:28:18
	*/
	public void setRank(int rank) {
		this.rank = rank;
	}






}
