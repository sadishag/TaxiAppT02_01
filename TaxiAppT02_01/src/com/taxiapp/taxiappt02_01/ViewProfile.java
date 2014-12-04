package com.taxiapp.taxiappt02_01;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.taxiapp.entities.CustomerInformation;

public class ViewProfile extends Activity {
//    
//    TextView fn = (TextView) findViewById(R.id.firstname);
//    TextView ln = (TextView) findViewById(R.id.lastname);
//    TextView em_text = (TextView) findViewById(R.id.emailText);
////    EditText em_edit = (EditText) findViewById(R.id.emailEdit);
//    TextView user = (TextView) findViewById(R.id.username);
//    TextView pw_text = (TextView) findViewById(R.id.passwordText);
////    EditText pw_edit = (EditText) findViewById(R.id.passwordEdit);
//    TextView g = (TextView) findViewById(R.id.gender);
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile);
        
        TextView fn = (TextView) findViewById(R.id.firstname);
        TextView ln = (TextView) findViewById(R.id.lastname);
        TextView em_text = (TextView) findViewById(R.id.emailText);
//        EditText em_edit = (EditText) findViewById(R.id.emailEdit);
        TextView user = (TextView) findViewById(R.id.username);
        TextView pw_text = (TextView) findViewById(R.id.passwordText);
//        EditText pw_edit = (EditText) findViewById(R.id.passwordEdit);
        TextView g = (TextView) findViewById(R.id.gender);
//        
        
        CharSequence firstname = (CharSequence) "First Name: "+CustomerInformation.getFirstname();
        CharSequence lastname = (CharSequence) "Last Name: "+CustomerInformation.getLastname();
        CharSequence email = (CharSequence) "Email: "+CustomerInformation.getEmail();
        CharSequence username = (CharSequence) "Username: "+CustomerInformation.getUsername();
        CharSequence password = (CharSequence) "Password: ";
        CharSequence gender = (CharSequence) "Gender: "+CustomerInformation.getGender();
        
                
        fn.setText(firstname);
        ln.setText(lastname);
        em_text.setText(email);
        user.setText(username);
        pw_text.setText(password);
        g.setText(gender);
        
    }
    
    public void modifyProfileEvent(View view) {
//        em_edit.setVisibility(1);
//        em_text.setVisibility(0);
        
//        pw_edit.setVisibility(1);
//        pw_text.setVisibility(0);
    }
}
