package com.example.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DisplayInputActivity extends Activity {
	TextView displayNameTextView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
        setContentView(R.layout.display_input);
       
		Intent intent = getIntent();
		String value = intent.getStringExtra("name"); //if it's a string you stored.
		
		displayNameTextView = (TextView)findViewById(R.id.displayInputTextField);
		displayNameTextView.setText("Hello, " + value + "!");
	}
	
	public void onExitPressed(View v) {
		Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
    	startActivity(myIntent);
	}

}
