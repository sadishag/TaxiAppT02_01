package com.taxiapp.taxiappt02_01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {


//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_book_ride);
//    }
//}

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

    public void pressRegister(View view) {
        Intent registerIntent = new Intent(this, RegisterScreen.class);
        startActivity(registerIntent);
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

