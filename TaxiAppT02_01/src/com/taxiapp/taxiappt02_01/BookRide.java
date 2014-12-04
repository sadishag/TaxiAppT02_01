package com.taxiapp.taxiappt02_01;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.taxiapp.entities.TaxiRideInformation;

public class BookRide extends Activity {
	
	static TextView date;
	Button bookButton;
	EditText toBook, fromBook;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_book_ride);
		
		bookButton = (Button) findViewById(R.id.submitButton);
		date = (TextView) findViewById(R.id.datebook);
		toBook = (EditText) findViewById(R.id.tobook);
		fromBook = (EditText) findViewById(R.id.frombook);
		
		setDate();
		
	}
	
	public void dateOnClick(View view){
		Intent calendarIntent = new Intent(BookRide.this, CalendarScreen.class);
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
	
//	@Override
//	protected void onResume() {
//		setDate();
//	}
	


}
