package com.taxiapp.taxiappt02_01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EmailSentNotificationScreen extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_email_sent_notification);
		
	}
	
	public void listenToDoneClick(View view) {
		
		Intent doneClickIntent = new Intent(this, MainActivity.class);
		startActivity(doneClickIntent);
	}
}