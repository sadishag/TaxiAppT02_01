package com.taxiapp.taxiappt02_01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class CalendarScreen extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.calendar_bottom_view);
		setContentView(R.layout.activity_calendar_screen);
		
        CalendarView mv = new CalendarView(this);
        setContentView(mv);
        
	}
	
	public void bookProceed(View view){
		Intent bookIntent = new Intent(this, BookRide.class);
		startActivity(bookIntent);
//		
//		
//		
//		BookRide book = new BookRide();
//		book.setDate();
	}
}
