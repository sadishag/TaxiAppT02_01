package com.taxiapp.taxiappt02_01;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class CalendarScreen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calendar_screen);
		
        CalendarView mv = new CalendarView(this);
        setContentView(mv);
	}
}
