package com.taxiapp.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;


public class ConverterController {
	
	public static double latitude;
	public static double longitude;
//	private static StringBuffer sb = new StringBuffer("");
//	public static StringBuilder stringBuilder = new StringBuilder();
	static StringBuilder sb = new StringBuilder();
	
	public static void getLatLongFromAddress(String youraddress) {
	    String uri = "http://maps.google.com/maps/api/geocode/json?address=" +
	                  youraddress + "&sensor=false";
	    
	    try {
//			URL url = new URL(uri);
			HttpClient client = new DefaultHttpClient();
			HttpPost request = new HttpPost();
			request.setURI(new URI(uri));
			HttpResponse response = client.execute(request);

			InputStream in = response.getEntity().getContent();
//			BufferedReader in = new BufferedReader(inStream);

			InputStreamReader is = new InputStreamReader(in);
			
			BufferedReader br = new BufferedReader(is);
			String read = br.readLine();

			while (read != null) {
			    //System.out.println(read);
			    sb.append(read);
			    read = br.readLine();

			}

//			return sb.toString();
			
//			int b;
//			while ((b = stream.read()) != -1) {
////				String s = new String(b);
//				stringBuilder.append((char) b);
//			}
//			String line="";
//			while ((line = in.readLine()) != null) {
//				sb.append(line);
////				break;
//			}
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
//			e1.printStackTrace();
		}
//	    Log.d(null, sb.toString());
//	    
//	    Log.d(null,uri);
//	    HttpGet httpGet = new HttpGet(uri);
//	    HttpClient client = new DefaultHttpClient();
//	    HttpResponse response;
//	    StringBuilder stringBuilder = new StringBuilder();
//
//	    try {
//	        response = client.execute(httpGet);
//	        HttpEntity entity = response.getEntity();
//	        InputStream stream = entity.getContent();
//	        int b;
//	        while ((b = stream.read()) != -1) {
//	            stringBuilder.append((char) b);
//	        }
//	    } catch (ClientProtocolException e) {
//	        e.printStackTrace();
//	    } catch (IOException e) {
//	        e.printStackTrace();
//	    }
	    JSONObject jsonObject = new JSONObject();
	    try {
	        jsonObject = new JSONObject(sb.toString());

	        double lng = ((JSONArray)jsonObject.get("results")).getJSONObject(0)
	            .getJSONObject("geometry").getJSONObject("location")
	            .getDouble("lng");

	        double lat = ((JSONArray)jsonObject.get("results")).getJSONObject(0)
	            .getJSONObject("geometry").getJSONObject("location")
	            .getDouble("lat");

	        Log.d("latitude", "" + lat);
	        Log.d("longitude", "" + lng);
	        
	        latitude = lat;
	        longitude = lng;
	        
	    } catch (JSONException e) {
	        e.printStackTrace();
	    }

	}
	
	

	
	public static double getLat() {
    	return latitude;
    }
	public static double getLng() {
		return longitude;
	}

}
