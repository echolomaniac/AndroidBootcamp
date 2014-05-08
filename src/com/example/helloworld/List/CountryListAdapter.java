package com.example.helloworld.List;


import java.util.ArrayList;

import com.example.helloworld.R;
import com.example.helloworld.models.Country;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CountryListAdapter extends ArrayAdapter<Country> {
	Context context;
	int layoutResourceId;
	ArrayList<Country> data = null;

	public CountryListAdapter(Context context, int layoutResourceId,
			ArrayList<Country> data) {
		super(context, layoutResourceId, data);
		// TODO Auto-generated constructor stub
		this.context = context;
		this.layoutResourceId = layoutResourceId;
		this.data = data;
	}

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    	View row = convertView;
    	CountryHolder holder = null;
    	
    	if(row == null) {
    		LayoutInflater inflater = ((Activity)context).getLayoutInflater();
    		row = inflater.inflate(layoutResourceId, parent, false);
    		
    		holder = new CountryHolder();
    		holder.countryImageView = (ImageView)row.findViewById(R.id.country_icon);
    		holder.countryTextView = (TextView)row.findViewById(R.id.country_title);
    		holder.countryDetailTextView = (TextView)row.findViewById(R.id.country_detail);
    		
    		row.setTag(holder);
    	}
    	else {
    		holder = (CountryHolder)row.getTag();
    	}
    	
    	Country country = data.get(position);
    	holder.countryTextView.setText(country.name);
    	holder.countryImageView.setImageResource(country.icon);
    	holder.countryDetailTextView.setText(country.detail);
    	
    	return row;
    }
    
    static class CountryHolder {
    	ImageView countryImageView;
    	TextView countryTextView;
    	TextView countryDetailTextView;
    }
	
}
