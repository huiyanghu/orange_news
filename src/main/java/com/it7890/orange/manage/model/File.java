package com.it7890.orange.manage.model;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;

/**
 * Created by Administrator on 2017/6/21.
 */
@AVClassName("_File")
public class File extends AVObject {
    public String type;
    public String bucket;
    public String key;
    public String mimeType;
    public String name;
    public String provider;
    public String url;

    public String getType() {
        return getString("__type");
    }

    public void setType(String type) {
        this.put("__type",type);
    }

    public String getBucket() {
        return getString("bucket");
    }

    public void setBucket(String bucket) {
        this.put("bucket",bucket);
    }

    public String getKey() {
        return getString("key");
    }

    public void setKey(String key) {
        this.put("key",key);
    }

    public String getMimeType() {
        return getString("mime_type");
    }

    public void setMimeType(String mimeType) {
        this.put("mime_type",mimeType);
    }

    public String getName() {
        return getString("name");
    }

    public void setName(String name) {
        this.put("name",name);
    }

    public String getProvider() {
        return getString("provider");
    }

    public void setProvider(String provider) {
        this.put("provider",provider);
    }

    public String getUrl() {
        return getString("url");
    }

    public void setUrl(String url) {
        this.put("url",url);
    }
}
