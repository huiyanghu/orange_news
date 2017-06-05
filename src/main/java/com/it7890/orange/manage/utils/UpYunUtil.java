package com.it7890.orange.manage.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * @Description:
 * @date 2015年10月20日 下午7:29:06
 */
//@Component
public class UpYunUtil {

    private static final Logger log = LoggerFactory.getLogger(UpYunUtil.class);

    @Value("#{configProperties['upyunmaster']}")
    private String upyunmaster;
    @Value("#{configProperties['upyunusers']}")
    private String upyunusers;
    @Value("#{configProperties['upyunpasswd']}")
    private String upyunpasswd;
    @Value("#{configProperties['upyunhttp']}")
    private String upyunhttp;
    @Value("#{configProperties['openmycdn']}")
    private int openmycdn;


    public boolean writeFile(String filename, byte[] bs) {
        /*boolean isok = false;
		if(bs==null){
			return isok;
		}
		UpYun uy = new UpYun(upyunmaster, upyunusers, upyunpasswd);
		try{
			isok = uy.writeFile(filename,bs);
		}catch(Exception e){
			log.error(e.getMessage());
		}
		return isok;*/
        return false;
    }

    public Map<String, String> getFileInfo(String path) {
		/*UpYun uy = new UpYun(upyunmaster, upyunusers, upyunpasswd);
		return uy.getFileInfo(path);*/
        return null;
    }

    public boolean delFile(String path) {
		/*UpYun uy = new UpYun(upyunmaster, upyunusers, upyunpasswd);
		return uy.deleteFile(path);*/
        return false;
    }

    public String getUpyunmaster() {
        return upyunmaster;
    }

    public void setUpyunmaster(String upyunmaster) {
        this.upyunmaster = upyunmaster;
    }

    public String getUpyunusers() {
        return upyunusers;
    }

    public void setUpyunusers(String upyunusers) {
        this.upyunusers = upyunusers;
    }

    public String getUpyunpasswd() {
        return upyunpasswd;
    }

    public void setUpyunpasswd(String upyunpasswd) {
        this.upyunpasswd = upyunpasswd;
    }

    public String getUpyunhttp() {
        return upyunhttp;
    }

    public void setUpyunhttp(String upyunhttp) {
        this.upyunhttp = upyunhttp;
    }


    public int getOpenmycdn() {
        return openmycdn;
    }


    public void setOpenmycdn(int openmycdn) {
        this.openmycdn = openmycdn;
    }

    public static void main(String[] args) throws FileNotFoundException {
        /**
         * http://zuoyoo-hk.b0.upaiyun.com
         * upyunmaster=zuoyoo-hk
         upyunusers=zuoyoo
         upyunpasswd=1qaz@WSX
         */
        UpYunUtil u = new UpYunUtil();
        u.setUpyunmaster("zuoyoo-hk");
        u.setUpyunusers("zuoyoo");
        u.setUpyunpasswd("1qaz@WSX");
//		String img="/Users/fujian/Downloads/191632175807023974.jpg";
//		FileOutputStream is=new FileOutputStream(img);
        u.delFile("/listruledata/bj_rule.json");
//		u.writeFile("/2016-05-09/ff1.jpg", bs);

    }

    public byte[] toBArray(InputStream is) throws IOException {
        ByteArrayOutputStream outp = new ByteArrayOutputStream();
        int ch = 0;
        while ((ch = is.read()) != -1)
            outp.write(ch);
        byte[] b = outp.toByteArray();
        return b;
    }

}
