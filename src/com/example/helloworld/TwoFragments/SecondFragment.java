package com.example.helloworld.TwoFragments;

import com.example.helloworld.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SecondFragment extends Fragment {
	TextView outputTextView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootView = inflater.inflate(R.layout.fragment_second, container, false);
		
		outputTextView = (TextView)rootView.findViewById(R.id.output_text_view);
		
		
		return rootView;
	}
	
	public void setOutput(String input) {
		outputTextView.setText(input);
	}

}
