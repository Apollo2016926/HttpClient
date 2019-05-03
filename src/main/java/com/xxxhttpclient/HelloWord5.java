package com.xxxhttpclient;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HelloWord5 {
	public static void main(String[] args) throws ClientProtocolException,
			IOException {

		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("http://www.tuicool.com");
		httpGet.setHeader(
				"User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.75 Safari/537.36");

		CloseableHttpResponse response = null;
		response = httpClient.execute(httpGet);
		HttpEntity entity = response.getEntity();
		String string = EntityUtils.toString(entity, "utf-8");
		System.out.println(entity.getContentType().getValue());//获取响应ContentType
		StatusLine statusLine = response.getStatusLine();//获取响应code
		System.out.println(statusLine.getStatusCode());
		response.close();
		httpClient.close();

	}
}
