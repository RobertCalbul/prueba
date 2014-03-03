package com.javacodegeeks.android.androidsocketclient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

public class httpHandler {

	public List<String> post(String posturl, String data) {
		List<String>datos = new ArrayList<String>();
		InputStream is = null;
		try {
			
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost(posturl);

			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("Usuario", data));

			httppost.setEntity(new UrlEncodedFormEntity(params));
			
			HttpResponse resp = httpclient.execute(httppost);
			HttpEntity ent = resp.getEntity();
			is = ent.getContent();
			//String text = EntityUtils.toString(ent);

		} catch (Exception e) {
			System.out.println("Error httpHandler : "+e.getMessage()+"  "+e.toString());
			
		}
		String result ="";
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line=reader.readLine())!=null)
				sb.append(line+"\n");		
			
			is.close();
			result = sb.toString();
				
		}catch(Exception e){
			
		}
		
		try{
			JSONArray jArray = new JSONArray(result);
			JSONObject json_data = new JSONObject();
			for(int i=0; i<jArray.length();i++){
				json_data=jArray.getJSONObject(i);	
				datos.add(json_data.getString("libro").toString());
			}

		}catch(Exception e){}
		
		return datos;

	}

}