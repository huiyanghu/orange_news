package com.it7890.orange.manage.utils;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import java.io.IOException;

public class HttpClientUtil {
	
	public static String getDoc(String url,String charset){
		try {
			HttpClient client = new HttpClient();
			client.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,charset);
			GetMethod getMethod = new GetMethod(url);
			int statusCode = client.executeMethod(getMethod);  
			String body = getMethod.getResponseBodyAsString();
			return body;
		} catch (HttpException e) {
//			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	/**
	 * 以“x”开头的编码的任务使用HTTPClient
	 */
	public static boolean check(String charset){
		return charset.startsWith("x")||charset.startsWith("X");
	}
	
	/**
	 * 对编码进行处理
	 * 	例如：xgbk —>gbk
	 */
	public static String getCharset(String charset){
		if(charset.length()>1){
			return charset.substring(1);
		}
		return charset;
	}
	
	public static void main(String[] args) {
		System.out.println(check("x43"));
		
	}
	
}
