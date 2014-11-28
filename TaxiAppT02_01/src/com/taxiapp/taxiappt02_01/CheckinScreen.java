package com.taxiapp.taxiappt02_01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class CheckinScreen extends Activity {

	private String qrcode; // The string that should save qr code value

	//add intent to call on zxing application: BarcodeScanner
	public void checkinScreen(View view){
		
		Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("com.google.zxing.client.android");
		startActivity(LaunchIntent);
	}



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_checkin_screen);
		
	}

	//getter for qrcode
	public String getQRCode(){
		return qrcode;
	}

}
