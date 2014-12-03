package com.taxiapp.dbutility;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

import com.taxiapp.taxiappt02_01.MainActivity;
import com.taxiapp.taxiappt02_01.RegisterScreen;



public class RegisterActivity  extends AsyncTask<String,Void,String>{
    
    private static final String TAG = "AsyncTask";
    
    MainActivity mainLogin = new MainActivity();
    
    private Boolean loginAccess;
    
    private boolean registrationAllow;

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

        try{

            String firstname = (String) arg0[0];
            String lastname = (String) arg0[1];
            String email = (String) arg0[2];
            String username = (String) arg0[3];
            String password = (String) arg0[4];
            String gender = (String) arg0[5];
            
            checkExist[0] = username;
            checkExist[1] = email;
            
            //check register values
            String checklink = "http://taxishare.site40.net/registercheck.php?username="+username+"&email="+email;
//            URL url = new URL(link);
            HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet();
            request.setURI(new URI(checklink));
            HttpResponse response = client.execute(request);

            InputStreamReader inStream = new InputStreamReader(response.getEntity().getContent());
            BufferedReader in = new BufferedReader(inStream);

            String line="";
            while ((line = in.readLine()) != null) {
                sb.append(line);
                break;
            }
            Log.d(TAG, "StringBuffer= " + sb.toString());
//            Log.d(TAG, "CheckAccess= " + checkAccess.toString());
            
            String[] dbValues = sb.toString().split(", ");
            
            if(dbValues[0].equals(checkExist[0]) || dbValues[1].equals(checkExist[1])){
                registrationAllow = false;
            } else {
                registrationAllow = true;
            }

            
            
            Log.d(TAG, "loginAccess= " + registrationAllow);

            in.close();

            return sb.toString();
//            String link = "http://taxishare.site40.net/register.php?firstname="+firstname+"&lastname="+lastname+
//                    "&email="+email+"&username="+username+"&password="+password+"&gender="+gender;
//            return "done";
        } catch(Exception e) {
            return new String("Exception: " + e.getMessage());
        }
    }
    
    @Override
    protected void onPostExecute(String result){
//      progress.cancel();
        if(loginAccess == true) {
            statusField.setText("Access Granted");
//            loginMain.loginProceed(); 
//          myHandler.sendEmptyMessage(0);
        }
        else {
            statusField.setText("Login Failed");
        }
    }
    
    Handler myHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
            case 0:
                // calling to this function from other pleaces
                // The notice call method of doing things
//                loginMain.loginProceed();
                break;
            default:
                break;
            }
        }
    };
    
    
    public boolean getLoginAccess() {
        
        return loginAccess;
    }
    
}