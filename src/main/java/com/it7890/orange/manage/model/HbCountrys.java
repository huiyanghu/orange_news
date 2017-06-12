package com.it7890.orange.manage.model;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;

/**
 * @author zhoujie@7890it.com
 * @ClassName: HbCountrys
 * @Description: 国家相关对象
 * @date 2015年10月15日 下午5:13:02
 */
@AVClassName("hb_countrys")
public class HbCountrys extends AVObject {

    /*public HbCountrys() {
        super();
    }

    private String cnName;
    private String continent;
    private String shortName;
    private String countryCode;*/

    public String getCnName() {
        return getString("cnName");
    }

    public void setCnName(String cnName) {
        this.put("cnName", cnName);
    }

    public String getContinent() {
        return getString("continent");
    }

    public void setContinent(String continent) {
        this.put("continent", continent);
    }

    public String getShortName() {
        return getString("shortName");
    }

    public void setShortName(String shortName) {
        this.put("shortName", shortName);
    }

    public String getCountryCode() {
        return getString("countryCode");
    }

    public void setCountryCode(String countryCode) {
        this.put("countryCode", countryCode);
    }
}
