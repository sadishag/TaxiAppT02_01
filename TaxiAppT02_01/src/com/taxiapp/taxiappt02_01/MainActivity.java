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
<<<<<<< HEAD
		Button registerButton = (Button) findViewById(R.id.register);
		
=======

>>>>>>> 38a3df43d48fddfe302b0bf709588d977fd85f1a

		mainMenuButton.setOnClickListener(new View.OnClickListener()
		{

			@Override
			public void onClick(View v) {


				startActivity(new Intent(MainActivity.this, MainMenu.class));

			}
		});
<<<<<<< HEAD
    }
//    registerButton.setOnClickListener(new View.OnClickListener()
//    {
//    
//        @Override
//        public void onClick(View v) {
//    
//    
//            startActivity(new Intent(MainActivity.this, RegisterScreen.class));
//    
//        }
//    });
//    }

//    public void pressRegister(View view) {
//        
//        //link Register button to RegisterScreen
//        Intent registerIntent = new Intent(this, RegisterScreen.class);
//        startActivity(registerIntent);
//    }
=======
	}

	public void pressRegister(View view) {
>>>>>>> 38a3df43d48fddfe302b0bf709588d977fd85f1a

		//link Register button to RegisterScreen
		Intent registerIntent = new Intent(this, RegisterScreen.class);
		startActivity(registerIntent);
	}

	
	public void listenToForgotPassword(View view) {
		
		Intent forgotPasswordIntent = new Intent(this, ResetPasswordScreen.class);
		startActivity(forgotPasswordIntent);
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

