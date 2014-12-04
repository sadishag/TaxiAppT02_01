package com.taxiapp.taxiappt02_01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class EndOfRideScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_of_ride_screen);
    }
    
	public void RatingOnClick(View view){
		Intent calendarIntent = new Intent(this, RatingForm.class);
		startActivity(calendarIntent);
	}
}
