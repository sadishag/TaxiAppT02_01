package com.taxiapp.taxiappt02_01;

import java.util.ArrayList;

import org.w3c.dom.Document;

import android.app.Activity;
import android.graphics.Color;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.StrictMode;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.plus.Plus.PlusOptions;

import com.taxiapp.controllers.BookingSessionController;

public class RideInProgressScreen extends Activity {

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
		LatLng userLocation = new LatLng(location.getLatitude(),location.getLongitude());


		map.setMyLocationEnabled(true);
		map.moveCamera(CameraUpdateFactory.newLatLngZoom(userLocation, 13));
		
		onWorking();

		map.addMarker(new MarkerOptions()
		.title("You Are Here")
		.position(userLocation));

	}

	
	GoogleMap mMap;
    BookingSessionController md;
    
	LatLng fromPosition = new LatLng(13.687140112679154, 100.53525868803263);
	LatLng toPosition = new LatLng(13.683660045847258, 100.53900808095932);
	
	public void onWorking() {
        
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        
        md = new BookingSessionController();
		mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();

		LatLng coordinates = new LatLng(13.685400079263206, 100.537133384495975);		
		mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(coordinates, 16));
		
		mMap.addMarker(new MarkerOptions().position(fromPosition).title("Start"));
		mMap.addMarker(new MarkerOptions().position(toPosition).title("End"));
		
		Document doc = md.getDirections(fromPosition, toPosition, BookingSessionController.MODE_DRIVING);
		int duration = md.getDurationValue(doc);
		String distance = md.getDistanceText(doc);
		String start_address = md.getStartAddress(doc);
		String copy_right = md.getCopyRights(doc);

		ArrayList<LatLng> directionPoint = md.getDirection(doc);
		com.google.android.gms.maps.model.PolylineOptions rectLine = new com.google.android.gms.maps.model.PolylineOptions().width(3).color(Color.RED);
		
		for(int i = 0 ; i < directionPoint.size() ; i++) {			
			rectLine.add(directionPoint.get(i));
		}
		
		mMap.addPolyline(rectLine);
    }

}
