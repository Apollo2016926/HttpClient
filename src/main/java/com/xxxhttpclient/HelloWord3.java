package com.xxxhttpclient;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HelloWord3 {
	public static void main(String[] args) throws ClientProtocolException,
			IOException {

		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("http://www.tuicool.com");
		// 部分网页限制只能浏览器才能访问 比如http://www.tuicool.com
		// <p>系统检测亲不是真人行为，因系统资源限制，我们只能拒绝你的请求。如果你有疑问，可以通过微博
		// http://weibo.com/tuicool2012/ 联系我们。</p>
		// 模拟谷歌浏览器内核
		httpGet.setHeader(
				"User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.75 Safari/537.36");

		CloseableHttpResponse response = null;
		response = httpClient.execute(httpGet);
		HttpEntity entity = response.getEntity();
		String string = EntityUtils.toString(entity, "utf-8");
		System.out.println(string);
		response.close();
		httpClient.close();

	}
}
