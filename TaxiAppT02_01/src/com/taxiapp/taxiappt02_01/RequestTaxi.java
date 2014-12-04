package com.taxiapp.taxiappt02_01;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.taxiapp.entities.TaxiRideInformation;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
//import android.view.Menu;
//import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RequestTaxi extends Activity{
	
	Button search;
	
	private EditText from; 
	private EditText to;
	private TextView date;
	private EditText number;
	private Button submit;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_request_ride);
		
		from = (EditText) findViewById(R.id.fromrequst);
		to = (EditText) findViewById(R.id.torequst);
		date = (TextView) findViewById(R.id.daterequst);
		number = (EditText) findViewById(R.id.numberrequst);
		submit = (Button) findViewById(R.id.event);
		
		setDate();
		
	}
	
	public void dateOnClick(View view){
		Intent calendarIntent = new Intent(this, CalendarScreen.class);
		startActivity(calendarIntent);
	}
	
	public void setDate() {
		
		if (TaxiRideInformation.getDate() != "") {
			String dateString = TaxiRideInformation.getDate();
			date.setText(dateString);
			date.setTextColor(Color.GRAY);
			}
		
		else{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			String currentDateandTime = sdf.format(new Date());
			date.setText(currentDateandTime);
			date.setTextColor(Color.GRAY);

		}
	}
}
