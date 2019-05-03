package com.xxxhttpclient;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HelloWord {
	public static void main(String[] args) {

		// 创建httpClient实例
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// 创建HttpGet实例
		HttpGet httpGet = new HttpGet("http://www.tuicool.com");
		// 执行http get请求
		CloseableHttpResponse response = null;
		try {
			response = httpClient.execute(httpGet);
		} catch (ClientProtocolException e) {
			// htytp协议异常
			e.printStackTrace();
		} catch (IOException e) {
			// io异常
			e.printStackTrace();
		}
		
		//获取返回实体
		HttpEntity entity = response.getEntity();
		
		try {
			//解析网页内容
			String string = EntityUtils.toString(entity,"gb2312");
			System.out.println(string);
		} catch (ParseException e) {
			//解析异常
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			response.close();
			httpClient.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
