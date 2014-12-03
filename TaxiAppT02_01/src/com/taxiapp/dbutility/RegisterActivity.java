package com.taxiapp.dbutility;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import com.taxiapp.controllers.SecurityController;
import com.taxiapp.taxiappt02_01.MainActivity;
import com.taxiapp.taxiappt02_01.RegisterScreen;



public class RegisterActivity  extends AsyncTask<String,Void,String>{

    private boolean registrationAllow;
    private String registrationError;

    private StringBuffer sb = new StringBuffer("");

    RegisterScreen registration;
    SecurityController security;

    ProgressDialog progress; 
    //  = ProgressDialog.show(context, "Processing...", "We are checking your credentials");

    public RegisterActivity(RegisterScreen registerScreen) {
        this.registration = registerScreen;
    }

    protected void onPreExecute(){
    }

    @Override
    protected String doInBackground(String... arg0) {
        try {
            String firstname = (String) arg0[0];
            String lastname = (String) arg0[1];
            String email = (String) arg0[2];
            String username = (String) arg0[3];
            String password = (String) arg0[4];
            String confirmPassword = (String) arg0[5];
            String gender = (String) arg0[6];

            if (!(password.equals(confirmPassword))) {
                registrationAllow = false;
                registrationError = "Passwords are not the same.";
                return "error";
            } 
            
            
            //check register values
            String link = "http://taxishare.site40.net/registerCheck.php?username="+username+"&email="+email;
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

            if (sb.toString().isEmpty()) {
                registrationAllow = true;
                byte[] passwordE = security.encrypt(password);
//                Log.d(TAG, "Password= " + passwordE.toString());
                String passwordEstring = new String(passwordE, "UTF-8");
                String tmpDecrypt = security.decrypt(passwordE);
//                Log.d(TAG, "DecryptedPassword= " + tmpDecrypt); //used just to show that decrypt works
                
                //add information to database
                String insertLink = "http://taxishare.site40.net/register.php?"+"firstname="+firstname+"&lastname="+lastname+"&email="+email+"&gender="+gender+"&username="+username+"&password="+passwordEstring;
                HttpPost post = new HttpPost(insertLink);
                client.execute(post);
            } else {
                registrationAllow = false;
                
                //get error type
                String[] resultSplit = sb.toString().split(",");
                if (resultSplit[0].equals(username)) { 
                    registrationError = "Username already exists.";
                } else {
                    registrationError = "Email is already registered.";
                }
            }

            in.close();

            return sb.toString();
            
        } catch(Exception e) {
            return new String("Exception: " + e.getMessage());
        }
    }

    @Override
    protected void onPostExecute(String result){
        if (registrationAllow == true) {
            registration.registerSuccessProceed();
        } else if (registrationAllow == false) {
            registration.registerErrorProceed(registrationError);
        }
    }

}