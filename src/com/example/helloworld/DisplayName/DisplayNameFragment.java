package com.example.helloworld.DisplayName;

import com.example.helloworld.R;
import com.example.helloworld.R.id;
import com.example.helloworld.R.layout;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DisplayNameFragment extends Fragment {
	TextView nameTextView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootView = inflater.inflate(R.layout.display_name_fragment, container, false);
		
		Intent intent= getActivity().getIntent();
		String name = intent.getStringExtra("name");
		
		nameTextView = (TextView)rootView.findViewById(R.id.display_name_textview);
		nameTextView.setText("Hi " + name + "!");
		
		return rootView;
	}
	
}
