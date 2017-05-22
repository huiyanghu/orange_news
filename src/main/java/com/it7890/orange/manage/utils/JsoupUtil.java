package com.it7890.orange.manage.utils;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsoupUtil {
	
	private static final Logger log = LoggerFactory.getLogger(JsoupUtil.class);
	protected static int timeout = 100000;

	public static  Document getDocument(String url, String charset) {
		Document doc = null;
		//charset="auto";
		if(url==null){
			return doc;
		}
		url=url.trim();
		try {
			if (Constant.AUTO.equals(charset)||"".equals(charset)||charset==null) {
				log.info("charset = "+charset+"; begin="+System.currentTimeMillis());
					 Connection conn = Jsoup.connect(url);
			            // 修改http包中的header,伪装成浏览器进行抓取
					 conn.timeout(timeout);
					 conn.ignoreContentType(true);
					 conn.ignoreHttpErrors(true);
					 conn.userAgent(UserAgentUtil.getUserAgent());
					 log.info("jsoup get doc");
			   try{
				doc = conn.get();
				log.info("charset = "+charset+"; end="+System.currentTimeMillis());
				}catch(Exception error){
					log.info("error message="+error.getMessage());
				}finally{
					log.info("检测编码方式");
					if (HttpClientUtil.check(charset)) {
						charset = HttpClientUtil.getCharset(charset);
						doc = Jsoup.parse(HttpClientUtil.getDoc(url, charset));
					}
					return doc;
				}
			} else {
				if (!HttpClientUtil.check(charset)) {
					doc = Jsoup
							.parse(new String(
									Jsoup.connect(url)
											.timeout(timeout)
											.ignoreContentType(true)
											.userAgent(UserAgentUtil.getUserAgent())
											.execute().bodyAsBytes(), charset));
				}
				log.info("检测编码方式");
				if (HttpClientUtil.check(charset)) {
					charset = HttpClientUtil.getCharset(charset);
					doc = Jsoup.parse(HttpClientUtil.getDoc(url, charset));
				}
			}
		} catch (Exception e) {
			log.info("url地址无效:" + url);
			log.info("url地址无效:" + e.getMessage());
		}
		return doc;
	}

	// 根据cssPath抓取内容
	public static String genTextOrHTMLByCssPath(Document doc, String cssPath,
			boolean isText) {
		if (cssPath.indexOf("|") != -1) {
			return genAttrByCssPath(doc, cssPath);
		}
		Elements es=null;
		try {
			es = doc.select(cssPath);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		if (es==null || es.size() == 0) {
			return "";
		}
		Element e = es.get(0);

		// 处理标签内容为空时，返回""
		String text = e.text();
		String html = e.toString();

		return isText ? text : html;
	}
	
	public static void rmByCsspath(Document doc ,String cssPath){
		Elements es = doc.select(cssPath);
		if(es.size()==0){
			return;
		}
		es.remove();
	}
	
	// 根据cssPath进行分解，表达式进行拆解解析
	public static String genAttrByCssPath(Document doc, String cssPath) {
		String[] strs = cssPath.split("\\|");
		if (strs.length == 2) {
			Elements es = doc.select(strs[0]);

			// System.out.println(es);
			if (es.size() == 0) {
				return "";
			}
			Element e = es.get(0);
			return e.attr(strs[1].trim());
		}
		return "";
	}

	
	 public static void main(String[] args) {
		 String url="https://plus.google.com/share?url=http://indiatoday.intoday.in/auto/story/exploring-seven-wonders-in-a-maruti-suzuki-ertiga-day-2/1/743892.html";
		 String charset="auto";
		 Document doc =getDocument(url, charset);
		 System.out.println(doc);
	}
}
