package com.taxiapp.taxiappt02_01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

<<<<<<< HEAD
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_ride);
    }
}
=======
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


		Button mainMenuButton = (Button) findViewById(R.id.login);

		mainMenuButton.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {


				startActivity(new Intent(MainActivity.this, MainMenu.class));

			}
		});
	}

	//	private void testMainMenu(View view){
	//
	//		
	//		
	////		// link Checkin button to CheckinScreen.
	////		Intent mainMenuIntent = new Intent(this, MainMenu.class);
	////		startActivity(mainMenuIntent);
	//	}
}
>>>>>>> a30af4dc945ca5c3f3dd04e08e5bd5b856a27f67
