package com.taxiapp.dbutility;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import com.taxiapp.taxiappt02_01.MainActivity;
import com.taxiapp.taxiappt02_01.RegisterScreen;



public class RegisterActivity  extends AsyncTask<String,Void,String>{

    private static final String TAG = "AsyncTask";

    MainActivity mainLogin = new MainActivity();

    private boolean registrationAllow;
    private String registrationInfo;
    private String registrationError;

    private TextView statusField;
    private TextView roleField;
    private StringBuffer sb = new StringBuffer("");
    private String[] checkExist;

    RegisterScreen registration;

    ProgressDialog progress; 
    //  = ProgressDialog.show(context, "Processing...", "We are checking your credentials");

    public RegisterActivity(RegisterScreen registerScreen) {
        this.registration = registerScreen;
    }

    protected void onPreExecute(){
    }

    @Override
    protected String doInBackground(String... arg0) {
//        Log.d(TAG, "dbValues");
        try {
//            Log.d(TAG, "dbValues");
            String firstname = (String) arg0[0];
            String lastname = (String) arg0[1];
            String email = (String) arg0[2];
            String username = (String) arg0[3];
            String password = (String) arg0[4];
            String confirmPassword = (String) arg0[5];
            String gender = (String) arg0[6];

//            if (!(password.equals(confirmPassword))) {
//                registrationAllow = false;
//                registrationError = "Passwords are not the same.";
//                Log.d(TAG, "passwords not the same");
//                return "error";
//            } 
            Log.d(TAG, "dbValues2");
            checkExist[0] = username;
            checkExist[1] = email;
            Log.d(TAG, "dbValues");
            //check register values
            String checklink = "http://taxishare.site40.net/registercheck.php?username="+username+"&email="+email;
//            URL url = new URL(link);
            HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet();
            request.setURI(new URI(checklink));
            HttpResponse response = client.execute(request);
//            Log.d(TAG, "dbValues");
            InputStreamReader inStream = new InputStreamReader(response.getEntity().getContent());
            BufferedReader in = new BufferedReader(inStream);

            String line="";
            while ((line = in.readLine()) != null) {
                sb.append(line);
                break;
            }
//            Log.d(TAG, "StringBuffer= " + sb.toString());
            //            Log.d(TAG, "CheckAccess= " + checkAccess.toString());

            String[] dbValues = sb.toString().split(", ");
//            Log.v("check values", "dbValues= " + dbValues[0]);
            if (dbValues[0].isEmpty()) {
                Log.d(TAG,"it is empty");
            }
            if (dbValues[0].equals(checkExist[0]) || dbValues[1].equals(checkExist[1])) {
                registrationAllow = false;
            } else {
                registrationAllow = true;
                registrationInfo = "firstname="+firstname+"&lastname="+lastname+"&email="+email+"&username="+username+"&password="+password+"&gender="+gender;
            }

            Log.d(TAG, "loginAccess= " + registrationAllow);

            in.close();

            return sb.toString();
            
            //            return "done";
        } catch(Exception e) {
            return new String("Exception: " + e.getMessage());
        }
    }

    @Override
    protected void onPostExecute(String result){
        if (registrationAllow == true) {
            String link = "http://taxishare.site40.net/register.php?"+registrationInfo;
            HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet();
            try {
                request.setURI(new URI(link));
                HttpResponse response = client.execute(request);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            registration.registerSuccessProceed();
        } else if (registrationAllow == false) {
            registration.registerErrorProceed();
        }
    }

}