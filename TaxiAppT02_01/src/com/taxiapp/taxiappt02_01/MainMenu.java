package com.taxiapp.taxiappt02_01;

import com.facebook.Session;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class MainMenu extends Activity {
	
	Button offer, requst, viewPro, viewRide, checkIn, logOut;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu);
		
		offer = (Button) findViewById(R.id.offertaxishare);
		requst = (Button) findViewById(R.id.requesttaxishare);
		viewPro = (Button) findViewById(R.id.viewprofile);
		viewRide = (Button) findViewById(R.id.viewrides);
		checkIn = (Button) findViewById(R.id.checkin);
		logOut = (Button) findViewById(R.id.logout);
		
		
		offer.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainMenu.this, OfferTaxi.class);
                startActivity(intent);  				
			}
		});
		
		
		//for requst taxi button
		
		requst.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainMenu.this, RequestTaxi.class);
                startActivity(intent);  				
			}
		});
		
		
		//for view profile button
//		viewPro.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				Intent intent = new Intent(MainMenu.this, viewPro.class);
//                startActivity(intent);  				
//			}
//		});
		
		//for view ride button
//		viewRide.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				Intent intent = new Intent(MainMenu.this, OfferTaxi.class);
//                startActivity(intent);  				
//			}
//		});
		
		
		//for check in button
		checkIn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainMenu.this, CheckinScreen.class).putExtra("this", "MainMenu");
                startActivity(intent);  				
			}
		});
		
		//for logout button
		logOut.setOnClickListener(new View.OnClickListener() {
           
			
			@Override
			public void onClick(View v) {
				
				  
				
				Intent intent = new Intent(MainMenu.this, MainActivity.class);
                startActivity(intent); 
                

				
			}
		});
	}
}
	
	