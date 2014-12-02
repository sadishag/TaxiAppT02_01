package com.taxiapp.taxiappt02_01;

import android.app.Activity;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;

//import com.google.android.gms.maps.CameraUpdateFactory;
//import com.google.android.gms.maps.GoogleMap;
//import com.google.android.gms.maps.MapFragment;
//import com.google.android.gms.maps.model.LatLng;
//import com.google.android.gms.maps.model.MarkerOptions;

public class RideInProgressScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ride_in_progress_screen);

            // Get a handle to the Map Fragment
//            GoogleMap map = ((MapFragment) getFragmentManager()
//                    .findFragmentById(R.id.map)).getMap();
//            
//            LocationManager service = (LocationManager) getSystemService(LOCATION_SERVICE);
//            Criteria criteria = new Criteria();
//            String provider = service.getBestProvider(criteria, false);
//            Location location = service.getLastKnownLocation(provider);
//            LatLng userLocation = new LatLng(location.getLatitude(),location.getLongitude());
//            
//
//            map.setMyLocationEnabled(true);
//            map.moveCamera(CameraUpdateFactory.newLatLngZoom(userLocation, 13));
//
//            map.addMarker(new MarkerOptions()
//                    .title("You Are Here")
//                    .position(userLocation));
        
    }
}
