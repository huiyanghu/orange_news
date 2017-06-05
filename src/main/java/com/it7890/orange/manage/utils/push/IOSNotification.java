package com.it7890.orange.manage.utils.push;

import org.json.JSONObject;

import java.util.Arrays;
import java.util.HashSet;

public abstract class IOSNotification extends Notification {
	
	// Keys can be set in the body level
	protected static final HashSet<String> APS_KEYS = new HashSet<String>(Arrays.asList(new String[]{
			"alert", "badge", "sound","content-available"}));
	protected static final HashSet<String> PAYLOAD_KEYS = new HashSet<String>(Arrays.asList(new String[]{
			"conjson"}));

	public enum AfterOpenAction{
        go_app,//打开应用
        go_url,//跳转到URL
        go_activity,//打开特定的activity
        go_custom//用户自定义内容。
	}
	// Set key/value in the rootJson, for the keys can be set please see ROOT_KEYS, PAYLOAD_KEYS, 
	// BODY_KEYS and POLICY_KEYS.
	@Override
	public boolean setPredefinedKeyValue(String key, Object value) throws Exception {
		if (ROOT_KEYS.contains(key)) {
			// This key should be in the root level
			rootJson.put(key, value);
		} else if (PAYLOAD_KEYS.contains(key)) {
			// This key should be in the payload level
			JSONObject payloadJson = null;
			if (rootJson.has("payload")) {
				payloadJson = rootJson.getJSONObject("payload");
			} else {
				payloadJson = new JSONObject();
				rootJson.put("payload", payloadJson);
			}
			payloadJson.put(key, value);
		}else if (APS_KEYS.contains(key)) {
			// This key should be in the body level
			JSONObject bodyJson = null;
			JSONObject payloadJson = null;
			// 'body' is under 'payload', so build a payload if it doesn't exist
			if (rootJson.has("payload")) {
				payloadJson = rootJson.getJSONObject("payload");
			} else {
				payloadJson = new JSONObject();
				rootJson.put("payload", payloadJson);
			}
			// Get body JSONObject, generate one if not existed
			if (payloadJson.has("aps")) {
				bodyJson = payloadJson.getJSONObject("aps");
			} else {
				bodyJson = new JSONObject();
				payloadJson.put("aps", bodyJson);
			}
			bodyJson.put(key, value);
		} else if (POLICY_KEYS.contains(key)) {
			// This key should be in the body level
			JSONObject policyJson = null;
			if (rootJson.has("policy")) {
				policyJson = rootJson.getJSONObject("policy");
			} else {
				policyJson = new JSONObject();
				rootJson.put("policy", policyJson);
			}
			policyJson.put(key, value);
		} else {
			if (key == "payload" || key == "aps" || key == "policy" || key == "extra") {
				throw new Exception("You don't need to set value for " + key + " , just set values for the sub keys in it.");
			} else {
				throw new Exception("Unknown key: " + key);
			}
		}
		return true;
	}
	
	
	///通知栏提示文字
	public void setAlert(String alert) throws Exception {
		setPredefinedKeyValue("alert", alert);
	}
	///通知标题
	public void setBadge(String badge) throws Exception {
		setPredefinedKeyValue("badge", badge);
	}
	///通知声音，R.raw.[sound]. 如果该字段为空，采用SDK默认的声音
	public void setSound(String sound) throws Exception {
		setPredefinedKeyValue("sound", sound);
	}
	///用于标识该通知采用的样式。使用该参数时, 必须在SDK里面实现自定义通知栏样式。
	public void setContentAvailable(Integer content_available) throws Exception {
		setPredefinedKeyValue("content-available", content_available);
	}
	
	public void setConjson(String conjson) throws Exception {
		setPredefinedKeyValue("conjson", conjson);
	}
}
