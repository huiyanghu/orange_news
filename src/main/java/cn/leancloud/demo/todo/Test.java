package cn.leancloud.demo.todo;

import com.alibaba.fastjson.JSON;
import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Astro on 17/5/11.
 */
@AVClassName("Test")
public class Test extends AVObject {

    public Test() {
        super();
    }

    public String getName() {
        return getString("name");
    }

    public void setName(String name) {
        this.put("name", name);
    }

    @Override
    public String toString() {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("name", this.getString("name"));
        result.put("objectId", this.getObjectId());
        result.put("createdAt", this.getCreatedAt());
        return JSON.toJSONString(result);
    }
}