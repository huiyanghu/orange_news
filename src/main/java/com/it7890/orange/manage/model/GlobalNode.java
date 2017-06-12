package com.it7890.orange.manage.model;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;

/**
 * Created by Administrator on 2017/5/19.
 */
@AVClassName("GlobalNode")
public class GlobalNode extends AVObject {

    /*public GlobalNode() {
        super();
    }*/
    /*
    private String nodecode;
    private String nodename;
    */

    public String getNodecode() {
        return getString("nodecode");
    }

    public void setNodecode(String nodecode) {
        this.put("nodecode", nodecode);
    }

    public String getNodename() {
        return getString("nodename");
    }

    public void setNodename(String nodename) {
        this.put("nodename", nodename);
    }
}
