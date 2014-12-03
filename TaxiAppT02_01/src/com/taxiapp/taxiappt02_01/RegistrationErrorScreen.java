package com.taxiapp.taxiappt02_01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RegistrationErrorScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_error_screen);
    }
    
    public void tryAgainButtonPress(View view) {
        Intent tryAgainIntent = new Intent(this, RegisterScreen.class);
        startActivity(tryAgainIntent);
    }
}
