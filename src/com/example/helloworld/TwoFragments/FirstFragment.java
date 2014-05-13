package com.example.helloworld.TwoFragments;

import com.example.helloworld.R;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FirstFragment extends Fragment {
	FirstFragmentInterface firstFragInterface;
	Button enterButton;
	EditText inputEditText;
	String input = null;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootView = inflater.inflate(R.layout.fragment_first, container, false);
		
		inputEditText = (EditText)rootView.findViewById(R.id.input_edit_text);
		
		
		enterButton = (Button)rootView.findViewById(R.id.input_button);
		enterButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				input = inputEditText.getText().toString();
				firstFragInterface.onClick(input);
			}
		});
		
		return rootView;
	}
	
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		
		try {
			firstFragInterface = (FirstFragmentInterface)activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString() + " must implement");
		}
	}
	
	public interface FirstFragmentInterface {
		public void onClick(String input);
	}

}
