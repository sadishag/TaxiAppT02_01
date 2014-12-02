package com.taxiapp.taxiappt02_01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Button;

public class RegisterScreen extends Activity {
	
    Button register;
    
	private EditText firstname;
	private EditText lastname;
	private EditText email;
	private EditText username;
	private EditText password;
	private String gender;
	

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register_screen);
		
		firstname = (EditText) findViewById(R.id.firstname);
		lastname = (EditText) findViewById(R.id.lastname);
		email = (EditText) findViewById(R.id.email);
		username = (EditText) findViewById(R.id.username);
		password = (EditText) findViewById(R.id.password);
		
		register = (Button) findViewById(R.id.register);
		
		register.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(RegisterScreen.this, RegistrationSuccessActivity.class);
	            startActivity(intent);  				
			}
		});
	}
		
		
		
	
	public void listenToRegister(View view) {
		String firstnameField = firstname.getText().toString();
		String lastnameField = lastname.getText().toString();
		String emailField = email.getText().toString();
		String usernameField = username.getText().toString();
		String passwordField = password.getText().toString();
		
	}
	
	
	
}

