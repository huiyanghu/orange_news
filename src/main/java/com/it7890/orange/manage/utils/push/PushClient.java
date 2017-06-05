package com.it7890.orange.manage.utils.push;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PushClient {
	
	// The user agent
	protected final String USER_AGENT = "Mozilla/5.0";

	// This object is used for sending the post request to Umeng
	protected HttpClient client = new DefaultHttpClient();
	
	// The host
	protected static final String host = "http://msg.umeng.com";
	
	protected static final String postPath = "/api/send";

	public String send(Notification msg) throws Exception {
		String timestamp = Integer.toString((int)(System.currentTimeMillis() / 1000));
		msg.setPredefinedKeyValue("timestamp", timestamp);
        String url = host + postPath;
        String postBody = msg.getPostBody();
        String sign = DigestUtils.md5Hex(("POST" + url + postBody + msg.getAppMasterSecret()).getBytes("utf8"));
        url = url + "?sign=" + sign;
        HttpPost post = new HttpPost(url);
        post.setHeader("User-Agent", USER_AGENT);
        StringEntity se = new StringEntity(postBody, "UTF-8");
        post.setEntity(se);
        // Send the post request and get the response
        HttpResponse response = client.execute(post);
        int status = response.getStatusLine().getStatusCode();
       // System.out.println("Response Code : " + response.getStatusLine().getStatusCode());
		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		//System.out.println(result.toString());
		// Decode response string and get file_id from it
		//JSONObject respJson = new JSONObject(result.toString());
		//System.out.println(respJson);
		/*String ret = respJson.getString("ret");
		JSONObject data = respJson.getJSONObject("data");*/
		//String fileId = data.getString("file_id");
        return status+"";
    }
	
	public static void main(String[] args) {
		PushClient c=new PushClient();
		IOSGroupcast groupcast;
		try {
			String title="IOS 测试";
			groupcast = new IOSGroupcast("568cc89567e58e7fe0001420","gbpgro5tdmbemyrt44lx9lgkrshoympx");
			JSONObject filterJson = new JSONObject();
			//JSONArray andJson = new JSONArray();
			JSONObject whereJson = new JSONObject();
			JSONArray andArray = new JSONArray();
			JSONArray orArray = new JSONArray();
			JSONObject countryTag = new JSONObject();
			JSONObject orTag = new JSONObject();
			ReadCountry rc = new ReadCountry();
			String countryName = "中国";
			countryTag.put("country", countryName);
			orArray.put(countryTag);
			orTag.put("or", orArray);
			andArray.put(orTag);
			whereJson.put("and", andArray);
			filterJson.put("where", whereJson);
			/*System.out.println(filterJson.toString());*/
			groupcast.setFilter(filterJson);
			if(title.length()>40){
				title = title.substring(0, 40);
			}
			groupcast.setAlert(title);
			groupcast.setDescription(countryName+":"+title);
			groupcast.setTestMode();
			String conjson="{\"id\":12411735,\"isgame\":1,\"linkurl\":\"http://www.coolook.top/article/12411735.html\",\"titlepic\":\"http://zuoyoo-hk.b0.upaiyun.com/2016-03-08/07904ab2aa66c28399ecb5576598850e.jpg!240\"}";
			groupcast.setConjson(conjson);
//			groupcast.setType("unicast");
//			groupcast.setDeviceTokens("35543edde2c4e1660cc3deabb2e5086342bac5eecbf2a07c348ee7ec570b3a31");
			c.send(groupcast);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
