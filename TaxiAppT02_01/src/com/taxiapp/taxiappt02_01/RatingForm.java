package com.taxiapp.taxiappt02_01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class RatingForm extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_form);
    }
    
	public void submitOnClick(View view){
		Intent submitIntent = new Intent(this, MainMenu.class);
		startActivity(submitIntent);
	}
}
