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

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;



public class SigninActivity  extends AsyncTask<String,Void,String>{
	
	private static final String TAG = "AsyncTask";
	
	MainActivity mainLogin = new MainActivity();
	
	private boolean loginAccess;

	private TextView statusField;
	private TextView roleField;
	private Context context;
	private int byGetOrPost = 0;
	private StringBuffer sb = new StringBuffer("");
	private String checkAccess;

	ProgressDialog progress; 
//	= ProgressDialog.show(context, "Processing...", "We are checking your credentials");
	
	
	//flag 0 means get and 1 means post.(By default it is get.)
	public SigninActivity(Context context,TextView statusField, TextView roleField,int flag) {
		progress = new ProgressDialog(context);
				
		this.context = context;
		this.statusField = statusField;
		this.roleField = roleField;
		byGetOrPost = flag;
	}

	protected void onPreExecute(){
		
		progress.setCancelable(false);
		progress.isIndeterminate();
		progress.show();

	}
	@Override
	protected String doInBackground(String... arg0) {


		//		if(byGetOrPost == 0){ //means by Get Method
		try{
			String username = (String)arg0[0];
			String password = (String)arg0[1];
			String link = "http://taxishare.site40.net/login.php?username="+username+"&password="+password;
			//				String link = "http://myphpmysqlweb.hostei.com/login.php?username="+username+"&password="+password;
			checkAccess = username + ", " + password;
			URL url = new URL(link);
			HttpClient client = new DefaultHttpClient();
			HttpGet request = new HttpGet();
			request.setURI(new URI(link));
			HttpResponse response = client.execute(request);

			InputStreamReader inStream = new InputStreamReader(response.getEntity().getContent());
			BufferedReader in = new BufferedReader(inStream);


			String line="";
			while ((line = in.readLine()) != null) {
				sb.append(line);
				break;
			}
			Log.d(TAG, "StringBuffer= " + sb.toString());
			Log.d(TAG, "CheckAccess= " + checkAccess.toString());

			if(sb.toString().equals(checkAccess.toString())){
				loginAccess = true;
			}
			else {
				loginAccess = false;
			}

			Log.d(TAG, "loginAccess= " + loginAccess);

			in.close();

			return sb.toString();
		}catch(Exception e){
			return new String("Exception: " + e.getMessage());
		}
	}
	
	@Override
	protected void onPostExecute(String result){
		progress.dismiss();
		if(loginAccess == true) {
			statusField.setText("Access Granted");
			mainLogin.proceedToMainMenu();
		}
		else {
			statusField.setText("Login Failed");
		}
	}
	
	
	
	
	public boolean getLoginAccess() {
		
		return loginAccess;
	}
	
}