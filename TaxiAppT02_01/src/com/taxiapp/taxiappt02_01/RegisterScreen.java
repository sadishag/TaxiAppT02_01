package com.taxiapp.taxiappt02_01;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.taxiapp.dbutility.RegisterActivity;
import com.taxiapp.dbutility.SigninActivity;

public class RegisterScreen extends Activity {

	private EditText firstname;
	private EditText lastname;
	private EditText email;
	private EditText username;
	private EditText password;
	private RadioGroup gender;
	
	RegisterActivity register;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register_screen);
		
		firstname = (EditText) findViewById(R.id.firstname);
		lastname = (EditText) findViewById(R.id.lastname);
		email = (EditText) findViewById(R.id.email);
		username = (EditText) findViewById(R.id.username);
		password = (EditText) findViewById(R.id.password);
		gender = (RadioGroup) findViewById(R.id.gender);
		
		
		
	}
	
	public void listenToRegister(View view) {
		String firstnameField = firstname.getText().toString();
		String lastnameField = lastname.getText().toString();
		String emailField = email.getText().toString();
		String usernameField = username.getText().toString();
		String passwordField = password.getText().toString();
		String genderField = "male";
		
		int selectedGenderID = gender.getCheckedRadioButtonId();
		if (selectedGenderID == 2) {
		    genderField = "female";
		} 
		
		register = new RegisterActivity(this);
//        register.execute(firstnameField,lastnameField,emailField,usernameField,passwordField,genderField);
		
	}
}
