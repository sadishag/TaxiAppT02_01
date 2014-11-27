package com.taxiapp.taxiappt02_01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ResetPasswordScreen extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reset_password_screen);
		
	}
	
	public void listenToSubmit(View view) {
		
		Intent submitIntent = new Intent(this, EmailSentNotificationScreen.class);
		startActivity(submitIntent);
	}

}
