package com.taxiapp.taxiappt02_01;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.taxiapp.entities.CustomerInformation;

public class ViewProfile extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile);
        
        TextView fn = (TextView) findViewById(R.id.firstname);
        TextView ln = (TextView) findViewById(R.id.lastname);
        TextView em = (TextView) findViewById(R.id.email);
        TextView user = (TextView) findViewById(R.id.username);
        TextView pw = (TextView) findViewById(R.id.password);
        TextView g = (TextView) findViewById(R.id.gender);
        
        
        CharSequence firstname = (CharSequence) "First Name: "+CustomerInformation.getFirstname();
        CharSequence lastname = (CharSequence) "Last Name: "+CustomerInformation.getLastname();
        CharSequence email = (CharSequence) "Email: "+CustomerInformation.getEmail();
        CharSequence username = (CharSequence) "Username: "+CustomerInformation.getUsername();
        CharSequence password = (CharSequence) "Password: "+CustomerInformation.getPassword();
        CharSequence gender = (CharSequence) "Gender: "+CustomerInformation.getGender();
        
                
        fn.setText(firstname);
        ln.setText(lastname);
        em.setText(email);
        user.setText(username);
        pw.setText(password);
        g.setText(gender);
        
    }
}
