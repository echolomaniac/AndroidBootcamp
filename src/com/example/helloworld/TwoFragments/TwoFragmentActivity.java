package com.example.helloworld.TwoFragments;

import com.example.helloworld.R;
import com.example.helloworld.TwoFragments.FirstFragment.FirstFragmentInterface;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class TwoFragmentActivity extends Activity implements FirstFragmentInterface {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_two_fragments);
	}
	
	
	public void onClick(String input) {
		SecondFragment second = (SecondFragment) getFragmentManager().findFragmentById(R.id.fragment2);
		
		if(second != null) {
			second.setOutput(input);
		}
	}
	
}
