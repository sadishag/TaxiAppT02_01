package com.taxiapp.taxiappt02_01;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class OfferTaxi extends Activity {

	Button offerCurrent, bookRide;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_offer_taxi);
		
		offerCurrent = (Button) findViewById(R.id.offerCurrent);
		bookRide = (Button) findViewById(R.id.bookRide);
		
		offerCurrent.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(OfferTaxi.this, CheckinScreen.class);
                startActivity(intent);  				
			}
		});
		
		bookRide.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(OfferTaxi.this, CalendarScreen.class);
                startActivity(intent);  				
			}
		});
		
	}
	
}
