package com.taxiapp.taxiappt02_01;



import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.taxiapp.dbutility.SigninActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;



public class MainActivity extends FragmentActivity{
    private MainFragment mainFragment;


    private static final String TAG = "MainActivity";

    private EditText usernameField;
	private EditText passwordField;
	private TextView status;
	private TextView role;
	
	private SigninActivity login;

	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		
		usernameField = (EditText)findViewById(R.id.username);
		passwordField = (EditText)findViewById(R.id.password);
		status = (TextView)findViewById(R.id.loginStatus);

		/*
		
		if (savedInstanceState == null) {
			// Add the fragment on initial activity setup
			mainFragment = new MainFragment();

			getSupportFragmentManager().beginTransaction()
					.add(android.R.id.content, mainFragment).commit();
		} else {
			// Or set the fragment from restored state info
			mainFragment = (MainFragment) getSupportFragmentManager()
					.findFragmentById(android.R.id.content);
		}
		*/
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

	
	public void facebookLogin(View view) {
	
	}
	
	
	
	public void listenToLogin(View view) {

		String username = usernameField.getText().toString();
		String password = passwordField.getText().toString();
		login = new SigninActivity(this,status,role);
		login.execute(username,password);

		
	}
	
	public void loginProceed(){
		Intent loginIntent = new Intent(this, MainMenu.class);
		startActivity(loginIntent);
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
	
	public void goToRideInProgressScreen(View view) {
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

