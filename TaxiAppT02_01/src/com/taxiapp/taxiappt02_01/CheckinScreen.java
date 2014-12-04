package com.taxiapp.taxiappt02_01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheckinScreen extends Activity {

	private String qrcode; // The string that should save qr code value

	private static final String TAG = "CheckinScreen";
	private Button scan;
	private TextView tv;

	//add intent to call on zxing application: BarcodeScanner
	//	public void checkinScreen(View view){
	//		
	//		Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("com.google.zxing.client.android");
	//		startActivity(LaunchIntent);
	//	}



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_checkin_screen);

		scan = (Button)findViewById(R.id.scanQRCodeButton);

	}


	public void openBarcodeScanner(View view) {

		Intent scannerIntent = new Intent("com.google.zxing.client.android.SCAN");
		scannerIntent.putExtra("SCAN_MODE", "QR_CODE_MODE");
		startActivityForResult(scannerIntent, 0);
	}

	public void onActivityResult(int requestCode, int resultCode, Intent scannerIntent) {
		if (requestCode == 0) {
			if (resultCode == RESULT_OK) {
				

				qrcode = scannerIntent.getStringExtra("SCAN_RESULT");
				String format = scannerIntent.getStringExtra("SCAN_RESULT_FORMAT");

				Log.d(TAG, "QRCODE= " + qrcode);
				// Handle successful scan
				
				if (getIntent().getStringExtra("this").equals("OfferTaxi")){
					scannerIntent = new Intent(this, OfferTaxiForm.class);
					startActivity(scannerIntent);
				}
				else{
					scannerIntent = new Intent(this, RideInProgressScreen.class);
					startActivity(scannerIntent);
				}
				

			} else if (resultCode == RESULT_CANCELED) {
				// Handle cancel
				Log.i(TAG,"Scan unsuccessful");
			}
		}
	}


	//getter for qrcode
	public String getQRCode(){
		return qrcode;
	}

}
