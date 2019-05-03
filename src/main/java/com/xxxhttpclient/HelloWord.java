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

		// ����httpClientʵ��
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// ����HttpGetʵ��
		HttpGet httpGet = new HttpGet("http://www.tuicool.com");
		// ִ��http get����
		CloseableHttpResponse response = null;
		try {
			response = httpClient.execute(httpGet);
		} catch (ClientProtocolException e) {
			// htytpЭ���쳣
			e.printStackTrace();
		} catch (IOException e) {
			// io�쳣
			e.printStackTrace();
		}
		
		//��ȡ����ʵ��
		HttpEntity entity = response.getEntity();
		
		try {
			//������ҳ����
			String string = EntityUtils.toString(entity,"gb2312");
			System.out.println(string);
		} catch (ParseException e) {
			//�����쳣
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
