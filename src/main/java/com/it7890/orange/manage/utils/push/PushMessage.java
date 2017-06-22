package com.it7890.orange.manage.utils.push;

import com.avos.avoscloud.AVPush;
import org.json.JSONArray;
import org.json.JSONObject;


/**
 * 给用户推送消息
 * @author zhuhuihua
 *
 */
public class PushMessage {
//	private static String appkey;
//	private static String appMasterSecret;
//	private static String iosappkey;
//	private static String iosappMasterSecret;
	private PushClient client = new PushClient();
//	public PushMessage(String appkey,String appMasterSecret,String iosappkey,String iosappMasterSecret){
//		PushMessage.appkey = appkey;
//		PushMessage.appMasterSecret = appMasterSecret;
//		PushMessage.iosappkey = iosappkey;
//		PushMessage.iosappMasterSecret = iosappMasterSecret;
//
//	}
    private static String appid;
    private static String appkey;
    private static String type;
    public PushMessage(String appid,String appkey,String type){
        PushMessage.appid = appid;
        PushMessage.appkey = appkey;
        PushMessage.type = type;
    }

	public PushMessage(){}
	/*static{
		InputStream in = PushMessage.class.getClassLoader().getResourceAsStream("common.properties");
		Properties prop = new Properties();
		try {
			prop.load(in);
			appkey = prop.getProperty("appkey");
			appMasterSecret = prop.getProperty("appMasterSecret");
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}*/
	/**
	 * 根据国家组发通知消息
	 * @param countryId 国家ID
	 * @param ticker 通知栏显示的信息
	 * @param title  标题
	 * @param text   内容
	 * @return string
	 * @throws Exception
	 */
	public String sendAndroidGroupcast(String countryId,String ticker,String title,String text, String url){
		AndroidGroupcast groupcast;
		try {
//			groupcast = new AndroidGroupcast(appkey,appMasterSecret);
//
//
//			JSONObject filterJson = new JSONObject();
//			JSONObject whereJson = new JSONObject();
//			JSONArray andArray = new JSONArray();
//			JSONArray orArray = new JSONArray();
//			JSONObject countryTag = new JSONObject();
//			JSONObject orTag = new JSONObject();
//			ReadCountry rc = new ReadCountry();
//			String countryName = rc.getCountryNameById(countryId);
//			countryTag.put("country", countryName);
//			orArray.put(countryTag);
//			orTag.put("or", orArray);
//			andArray.put(orTag);
//			whereJson.put("and", andArray);
//			filterJson.put("where", whereJson);
//			/*System.out.println(filterJson.toString());*/
//			groupcast.setFilter(filterJson);
//			groupcast.setTicker(ticker);
//			if(title.length()>40){
//				title = title.substring(0, 40);
//			}
//			if(text.length() > 60){
//				text = text.substring(0,60);
//			}
//			groupcast.setTitle(title);
//			groupcast.setText(text);
//			groupcast.setDescription(countryName+":"+title);
//			groupcast.goCustomAfterOpen(url);
//			groupcast.setDisplayType(AndroidNotification.DisplayType.NOTIFICATION);
//			groupcast.setProductionMode();
//			return client.send(groupcast);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
        return null;
	}
	
	
//	/**
//	 * 根据国家组发通知消息
//	 * @param countryId 国家ID
//	 * @param ticker 通知栏显示的信息
//	 * @param title  标题
//	 * @param text   内容
//	 * @return string
//	 * @throws Exception
//	 */
//	public String sendIOSGroupcast(String countryId,String ticker,String title,String text, String conjson){
//		IOSGroupcast groupcast;
//		try {
//			groupcast = new IOSGroupcast(iosappkey,iosappMasterSecret);
//
//
//			JSONObject filterJson = new JSONObject();
//			//JSONArray andJson = new JSONArray();
//			JSONObject whereJson = new JSONObject();
//			JSONArray andArray = new JSONArray();
//			JSONArray orArray = new JSONArray();
//			JSONObject countryTag = new JSONObject();
//			JSONObject orTag = new JSONObject();
//			ReadCountry rc = new ReadCountry();
//			String countryName = rc.getCountryNameById(countryId);
//			countryTag.put("country", countryName);
//			orArray.put(countryTag);
//			orTag.put("or", orArray);
//			andArray.put(orTag);
//			whereJson.put("and", andArray);
//			filterJson.put("where", whereJson);
//			/*System.out.println(filterJson.toString());*/
//			groupcast.setFilter(filterJson);
//			if(title.length()>40){
//				title = title.substring(0, 40);
//			}
//			if(text.length() > 60){
//				text = text.substring(0,60);
//			}
//			groupcast.setAlert(title);
//			groupcast.setDescription(countryName+":"+title);
//			groupcast.setProductionMode();
//			groupcast.setConjson(conjson);
//			String postBody = groupcast.getPostBody();
//			System.out.println(postBody);
//			return client.send(groupcast);
////			return null;
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new RuntimeException();
//		}
//	}

//    public String sendAvoTest(String url){
//        AndroidGroupcast groupcast;
//        AVPush.sendDataInBackground();
//        try {
//            return client.send(groupcast);
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new RuntimeException();
//        }
//    }
//    public static void main(String[] args) {
//		PushMessage push = new PushMessage("VV7zErT5UtBfnhkkllg9wboY-MdYXbMMI","q8QNg0P0npQDGWlsQh8HbtgS","application/json");
//        push.
//		System.out.println(push.sendAndroidGroupcast("11","ahgge","geeg","gee",null));
//		PushMessage push = new PushMessage(null,null,"55f8d848e0f55a8e83003006","4advnv7rq0zaaedj1wxm3wl4vjuv5zep");
//		System.out.println(push.sendIOSGroupcast("11","ahgge","geeg","gee",null));

//	}
}
