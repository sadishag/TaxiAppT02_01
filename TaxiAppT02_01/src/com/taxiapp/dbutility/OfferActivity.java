package com.taxiapp.dbutility;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import com.taxiapp.controllers.SecurityController;

import android.os.AsyncTask;

public class OfferActivity extends AsyncTask<String,Void,String> {

    SecurityController security = new SecurityController();
    StringBuffer sb = new StringBuffer();
    
    
    protected void onPreExecute(){
    }
    
    @Override
    protected String doInBackground(String... arg0) {
        
        try {
            String origin = (String) arg0[0];
            String destination = (String) arg0[1];
            String seatsAvailable = (String) arg0[2];
            String username = (String) arg0[3];
            
            
            
            //check register values
            String link = "http://taxishare.site40.net/offerTaxi.php?username="+username+"&origin="+origin+"&destination="+destination+"&seatsAvailable="+seatsAvailable;
            HttpClient client = new DefaultHttpClient();
            HttpPost request = new HttpPost(link);
//            request.setURI(new URI(link));
            client.execute(request);
            
            

            return sb.toString();
            
        } catch(Exception e) {
            return new String("Exception: " + e.getMessage());
        }
    }

    @Override
    protected void onPostExecute(String result){
    }
    

}
