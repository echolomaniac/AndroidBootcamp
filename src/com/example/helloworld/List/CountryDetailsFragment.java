package com.example.helloworld.List;

import com.example.helloworld.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CountryDetailsFragment extends Fragment{
	TextView nameTextView;
	TextView detailTextView;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootView = inflater.inflate(R.layout.fragment_country_detail, container, false);
		
		nameTextView = (TextView)rootView.findViewById(R.id.country_name);
		detailTextView = (TextView)rootView.findViewById(R.id.country_detail);
		
		return rootView;
	}
	
	public void setCountryDetails(String name, String details) {
		nameTextView.setText(name);
		detailTextView.setText(details);
	}

}
