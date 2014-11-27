package com.taxiapp.taxiappt02_01;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class MainMenu extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu);
		
		
	}
	
	public void checkinButtonOnClick(View v){
		
		Intent checkinScreenIntent = new Intent(this, CheckinScreen.class);
		startActivity(checkinScreenIntent);
				
	}
	
	
//	private void addListenerOnButton(){
//		
//		final Context context = this;
//		
//		Button button = (Button) findViewById(R.id.checkin);
//		
//		button.setOnClickListener(new OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//				Intent intent = new Intent(context, CheckinScreen.class);
//				startActivity(intent);
//				
//			}
//			
//		});
//	}
		
	
//	private void checkinScreenLaunch(View view){
//		
//		// link Checkin button to CheckinScreen.
//		Intent checkinIntent = new Intent(this, CheckinScreen.class);
//		startActivity(checkinIntent);
//	}
	
	
}
