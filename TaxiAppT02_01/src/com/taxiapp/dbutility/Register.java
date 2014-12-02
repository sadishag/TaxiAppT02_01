package com.taxiapp.dbutility;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.taxiapp.taxiappt02_01.MainActivity;
import com.taxiapp.taxiappt02_01.MainMenu;
import com.taxiapp.taxiappt02_01.RegisterScreen;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

public class Register extends AsyncTask<String,Void,String> {
	
	private static final String TAG = "Register";
	
	
	private Context context;
	private int byGetOrPost = 0;
	
	private StringBuffer sb = new StringBuffer("");
	private String checkAccess;


	private RegisterScreen registerScreen;
	
	
	public Register(RegisterScreen registerScreen) {
		
		this.registerScreen = registerScreen;
		
	}
	
	protected void onPreExecute(){
		
	}
	
	// execute(firstnameField, lastnameField, emailField, gender, usernameField, passwordField); 
	@Override
	protected String doInBackground(String... params) {
		try{
			
			String firstname = (String)params[0];
			String lastname = (String)params[1];
			String email = (String)params[2];
			String gender = (String)params[3];
			String username = (String)params[4];
			String password = (String)params[5];
			String link = "http://taxishare.site40.net/register.php?username="+username+"&password="+password+"&firstname="+firstname+"&lastname="+lastname+"&email="+email+"&gender="+gender;
			
			
			HttpClient client = new DefaultHttpClient();
			HttpGet request = new HttpGet();
			request.setURI(new URI(link));
			HttpResponse response = client.execute(request);
			
		
			return "done";
		}catch(Exception e){
			return new String("Exception: " + e.getMessage());
		}
	}
	protected void onPostExecute(){
		
	}

}
