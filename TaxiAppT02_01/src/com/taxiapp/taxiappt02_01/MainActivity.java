package com.taxiapp.taxiappt02_01;



import java.util.concurrent.ExecutionException;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.taxiapp.dbutility.SigninActivity;

public class MainActivity extends Activity {
    private static final String TAG = "MainActivity";

    private EditText usernameField;
	 private EditText passwordField;
	 private TextView status;
	 private TextView role;
	
	 SigninActivity login;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		usernameField = (EditText)findViewById(R.id.username);
		passwordField = (EditText)findViewById(R.id.password);
		status = (TextView)findViewById(R.id.loginStatus);
		
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
//	    Intent mainMenuIntent = new Intent(this, MainMenu.class);
//	    startActivity(mainMenuIntent);
		String username = usernameField.getText().toString();
		String password = passwordField.getText().toString();
		login = new SigninActivity(this,status,role);
		login.execute(username,password);
//		try {
//            login.execute(username,password).get();
//        } catch (InterruptedException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//		boolean loginAccess = login.getLoginAccess();
//		if (loginAccess == true) {
//			Intent mainMenuIntent = new Intent(this, MainMenu.class);
//		    startActivity(mainMenuIntent);
//		}
//		else {
//		    //loginErrorScreen goes here
//		}
		
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

