package com.taxiapp.taxiappt02_01;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;

import android.app.Activity;
import android.graphics.Color;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;


import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.identity.intents.Address;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.plus.Plus.PlusOptions;

import com.taxiapp.controllers.BookingSessionController;
import com.taxiapp.controllers.ConverterController;

public class RideInProgressScreen extends Activity {
	
	private static final String TAG = "RideInProgressScreen";
	GoogleMap mMap;
	BookingSessionController md;
	
	public String first = "10aquilaplacehamiltonontario";
	public String second = "McMaster";
	

	LatLng fromPosition;
	LatLng toPosition;
	
	LatLng userLocation;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ride_in_progress_screen);

		// Get a handle to the Map Fragment
		GoogleMap map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();

		LocationManager service = (LocationManager) getSystemService(LOCATION_SERVICE);
		Criteria criteria = new Criteria();
		String provider = service.getBestProvider(criteria, false);
		Location location = service.getLastKnownLocation(provider);
		userLocation = new LatLng(location.getLatitude(),location.getLongitude());


		map.setMyLocationEnabled(true);
		map.moveCamera(CameraUpdateFactory.newLatLngZoom(userLocation, 13));
		
		
//		double firstLat = Test.latitude;
//		double firstLng = Test.longitude;
//		fromPosition = new LatLng(firstLat, firstLng);
//		
//		Test.getLatLongFromAddress("")
//		
//		fromPosition = new LatLng(43.260879, -79.919225);
//		toPosition = new LatLng(43.209326, -79.870251);
//		onWorking();
		ConverterController.getLatLongFromAddress(first);
		double firstLat = ConverterController.latitude;
		double firstLng = ConverterController.longitude;
		fromPosition = new LatLng(firstLat, firstLng);
		Log.d("LATLNG", fromPosition.toString());
		ConverterController.getLatLongFromAddress(second);
		double secondLat = ConverterController.latitude;
		double secondLng = ConverterController.longitude;
		toPosition = new LatLng(secondLat, secondLng);
//		onWorking();
		onProceed();
		
		
//		map.addMarker(new MarkerOptions()
//		.title("You Are Here")
//		.position(userLocation));

	}
	
	public void onProceed() {
		onWorking();
	}
	
//	public void getLatLongFromAddress(String youraddress) {
//	    String uri = "http://maps.google.com/maps/api/geocode/json?address=" +
//	                  youraddress + "&sensor=false";
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
//
//	    JSONObject jsonObject = new JSONObject();
//	    try {
//	        jsonObject = new JSONObject(stringBuilder.toString());
//
//	        double lng = ((JSONArray)jsonObject.get("results")).getJSONObject(0)
//	            .getJSONObject("geometry").getJSONObject("location")
//	            .getDouble("lng");
//
//	        double lat = ((JSONArray)jsonObject.get("results")).getJSONObject(0)
//	            .getJSONObject("geometry").getJSONObject("location")
//	            .getDouble("lat");
//
//	        Log.d("latitude", "" + lat);
//	        Log.d("longitude", "" + lng);
//	        
//	        
//				onWorking();
//			
//			
//	    } catch (JSONException e) {
//	        e.printStackTrace();
//	    }
//
//	}
	
	
	public void onWorking() {

		if (android.os.Build.VERSION.SDK_INT > 9) {
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
			StrictMode.setThreadPolicy(policy);
		}

		BookingSessionController md = new BookingSessionController();

		mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
	
		mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(userLocation, 16));

		mMap.addMarker(new MarkerOptions().position(fromPosition).title("Start"));
		mMap.addMarker(new MarkerOptions().position(toPosition).title("End"));

		Document doc = md.getDirections(fromPosition, toPosition, BookingSessionController.MODE_DRIVING);
//		int duration = md.getDurationValue(doc);
//		String distance = md.getDistanceText(doc);
//		String start_address = md.getStartAddress(doc);
//		String copy_right = md.getCopyRights(doc);

		ArrayList<LatLng> directionPoint = md.getDirection(doc);
		com.google.android.gms.maps.model.PolylineOptions rectLine = new com.google.android.gms.maps.model.PolylineOptions().width(3).color(Color.RED);

		for(int i = 0 ; i < directionPoint.size() ; i++) {			
			rectLine.add(directionPoint.get(i));
		}

		mMap.addPolyline(rectLine);
	}
	

}
