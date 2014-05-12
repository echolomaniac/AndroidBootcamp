package com.example.helloworld.DisplayName;

import com.example.helloworld.R;
import com.example.helloworld.R.layout;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
