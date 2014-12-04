package com.taxiapp.taxiappt02_01;

import com.taxiapp.dbutility.OfferActivity;
import com.taxiapp.entities.CustomerInformation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class OfferTaxiForm extends Activity{
	//private TextView taxiID;
	private EditText origin;
	private EditText destination;
	private EditText seatsAvailable;
	private String qrCode;
	
	OfferActivity offer;
	CharSequence username;
	
	
//	CheckinScreen checkin = new CheckinScreen();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_offer_forms);
		
		//taxiID = (TextView)findViewById(R.id.taxiIDTextView);
		origin = (EditText)findViewById(R.id.originEditText);
		destination = (EditText)findViewById(R.id.destinationEditText);
		seatsAvailable = (EditText)findViewById(R.id.seatsAvailableEditText);
		
		 username = (CharSequence) "Username: "+CustomerInformation.getUsername();
		
		//taxiID.setText("Scan Successful"); 
		
	}
	
	public void listenToSubmit(View view) {
		String originField = origin.getText().toString();
		String destinationField = destination.getText().toString();
		String seatsAvailableField = seatsAvailable.getText().toString();
		String usernameField = username.toString();
		
		offer = new OfferActivity();
		offer.execute(originField,destinationField,seatsAvailableField,usernameField);
		
		
		Intent thisSendsToDispatcher = new Intent(this, RideInProgressScreen.class);
		startActivity(thisSendsToDispatcher);
	}

}
