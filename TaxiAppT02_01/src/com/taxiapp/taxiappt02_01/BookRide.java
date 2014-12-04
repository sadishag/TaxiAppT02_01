package com.taxiapp.taxiappt02_01;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String currentDateandTime = sdf.format(new Date());
		
		date.setText(currentDateandTime);
		date.setTextColor(Color.GRAY);
		
	}
	
	public void dateOnClick(View view){
		Intent calendarIntent = new Intent(BookRide.this, CalendarScreen.class);
		startActivity(calendarIntent);
	}

}
