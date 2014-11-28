package com.taxiapp.taxiappt02_01;



import com.taxiapp.dbutility.SigninActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	 private EditText usernameField;
	 private EditText passwordField;
	 private TextView status;
	 private TextView role;
	 private TextView method;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		usernameField = (EditText)findViewById(R.id.username);
		passwordField = (EditText)findViewById(R.id.password);
		

	}
	
	
//    registerButton.setOnClickListener(new View.OnClickListener()
//    {
//    
//        @Override
//        public void onClick(View v) {
//    
//    
//            startActivity(new Intent(MainActivity.this, RegisterScreen.class));
//    
//        }
//    });
//    }

//    public void pressRegister(View view) {
//        
//        //link Register button to RegisterScreen
//        Intent registerIntent = new Intent(this, RegisterScreen.class);
//        startActivity(registerIntent);
//    }
//	}

	public void listenToLogin(View view) {
		
		String username = usernameField.getText().toString();
		String password = passwordField.getText().toString();
		method.setText("Get Method");
		SigninActivity login = new SigninActivity(this,status,role,0);
		Log.d("LoginResult", login.execute(username,password).toString());
		
		if(login.execute(username,password).toString() != null) {
			
			Intent loginIntent = new Intent(this, MainMenu.class);
			startActivity(loginIntent);
		} 
		else {
			//do nothing...
		}

	}
	
	public void pressRegister(View view) {

		//link Register button to RegisterScreen
		Intent registerIntent = new Intent(this, RegisterScreen.class);
		startActivity(registerIntent);
	}

	
	public void listenToForgotPassword(View view) {
		
		Intent forgotPasswordIntent = new Intent(this, ResetPasswordScreen.class);
		startActivity(forgotPasswordIntent);
	}
	
	public void goToRideInProgressScren(View view) {
	    Intent rideInProgressIntent = new Intent(this, RideInProgressScreen.class);
	    startActivity(rideInProgressIntent);
	}
	
	//	private void testMainMenu(View view){
	//
	//		
	//		
	////		// link Checkin button to CheckinScreen.
	////		Intent mainMenuIntent = new Intent(this, MainMenu.class);
	////		startActivity(mainMenuIntent);
	//	}
}

