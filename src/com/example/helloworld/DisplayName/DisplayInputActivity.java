package com.example.helloworld.DisplayName;

import com.example.helloworld.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayInputActivity extends Activity {
	TextView displayNameTextView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
        setContentView(R.layout.display_input);

	}
}
