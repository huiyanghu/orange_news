package com.it7890.orange.manage.vo;

import com.avos.avoscloud.AVObject;
import com.it7890.orange.manage.controller.RecommendArtControler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HbCountrysDTO {
    private static final Logger logger = LogManager.getLogger(HbCountrysDTO.class);

    private String cnName;
    private String continent;
    private String shortName;
    private String countryCode;
    private String countryId;


    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public static HbCountrysDTO avo2dto(AVObject avo){
        HbCountrysDTO hbCountrysDTO = null;
        if (avo!=null){
            hbCountrysDTO = new HbCountrysDTO();
            hbCountrysDTO.setCnName(avo.getString("cnName"));
            hbCountrysDTO.setContinent(avo.getString("continent"));
            hbCountrysDTO.setCountryCode(avo.getString("countryCode"));
            hbCountrysDTO.setShortName(avo.getString("shortName"));
            hbCountrysDTO.setCountryId(avo.getObjectId());
        }
        return hbCountrysDTO;
    }
}
