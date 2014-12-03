package com.taxiapp.taxiappt02_01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
//import android.view.Menu;
//import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RequestTaxi extends Activity{
	
	Button search;
	
	private EditText from; 
	private EditText to;
	private EditText date;
	private EditText time;
	private EditText numberofriders;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_request_ride);
		
		from = (EditText) findViewById(R.id.from);
		to = (EditText) findViewById(R.id.to);
		date = (EditText) findViewById(R.id.date);
		time = (EditText) findViewById(R.id.time);
		numberofriders = (EditText) findViewById(R.id.numberofriders);
	}
	
	public void listenToRegister(View view) {
		String fromfield = from.getText().toString();
		String destinationfield = to.getText().toString();
		String datefield = date.getText().toString();
		String timefield = time.getText().toString();
		String numberofridersfield = numberofriders.getText().toString();
		
	}
}
