package com.qa.client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;


public class RestClient {
	
	
	//1.Get Method 
	public void get(String url) throws ClientProtocolException, IOException {
	CloseableHttpClient httpclient= HttpClients.createDefault(); 
	HttpGet httpget= new HttpGet(url);               //http get request
	CloseableHttpResponse closeableHttpResponse= httpclient.execute(httpget);   // hit the get GET URL
	
	// statuscode
	int  statusCode= closeableHttpResponse.getStatusLine().getStatusCode(); 
	System.out.println("Status Code--->"+ statusCode);
	
	// json response
	String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");
	JSONObject responsejsonObject= new JSONObject(responseString);
	System.out.println("Response JSON from API--->"+responsejsonObject);
	
	//all header response
	Header[] headerArray= closeableHttpResponse.getAllHeaders();
	HashMap<String,String> allheaders= new HashMap<String,String>();
	for(Header header:headerArray)
	{
		allheaders.put(header.getName(),header.getValue());
	}
	System.out.println("Headers Array--->"+allheaders);
	
	}

}
