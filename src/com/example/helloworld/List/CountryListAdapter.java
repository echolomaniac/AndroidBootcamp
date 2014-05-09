package com.example.helloworld.List;


import java.security.PublicKey;
import java.util.ArrayList;

import com.example.helloworld.R;
import com.example.helloworld.models.Country;
import com.example.helloworld.models.CountrySection;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CountryListAdapter extends ArrayAdapter<Country> {
	Context context;
	ArrayList data = null;
	LayoutInflater inflater;

	public CountryListAdapter(Context context, ArrayList data) {
		super(context, 0, data);
		// TODO Auto-generated constructor stub
		this.context = context;
		this.data = data;
		
		inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    	View row = convertView;
    	CountryHolder holder = null;
    	SectionHolder section = null;
    	final Item item = (Item)data.get(position);
    	
    	Log.v("TEST", "ROW:" + row);
    	//if(row == null) {
    		if(item != null) {
    			if(item.isSection()) {
    				CountrySection sect = (CountrySection)item;
    				
		    		row = inflater.inflate(R.layout.country_section_header, parent, false);
		    		
		    		row.setOnClickListener(null);
		    		row.setOnLongClickListener(null);
		    		row.setLongClickable(false);
		    		
		    		section = new SectionHolder();
		    		section.sectionTitle = (TextView)row.findViewById(R.id.section_header);
		    		
		    		section.sectionTitle.setText(sect.getTitle().substring(8));
		    		Log.v("TEST", "SECTION:" + item);
		    		row.setTag(section);
    			}
    			else {
    				Log.v("TEST", "ITEM:" + item);
    				Country country = (Country)item;
    				
		    		row = inflater.inflate(R.layout.listview_item_row, parent, false);
    				
    				holder = new CountryHolder();
		    		holder.countryImageView = (ImageView)row.findViewById(R.id.country_icon);
		    		holder.countryTextView = (TextView)row.findViewById(R.id.country_title);
		    		holder.countryDetailTextView = (TextView)row.findViewById(R.id.country_detail);
		    		
    		    	holder.countryTextView.setText(country.getName());
    		    	holder.countryImageView.setImageResource(country.getIcon());
    		    	holder.countryDetailTextView.setText(country.getDetail());
    		    	
    		    	row.setTag(holder);
    			}
    		}
    	/*}
    	else {
    		if(item != null) {
    			if(item.isSection()) {
    				Log.v("TEST", "SECTION tag:" + item);
    				section = (SectionHolder)row.getTag();
    			}
    			else {
    				Log.v("TEST", "ITEM tag:" + item);
    				holder = (CountryHolder)row.getTag();
    			}
    		}
    		
    	}*/
    	
    	return row;
    	
    }
    
    
    static class CountryHolder {
    	ImageView countryImageView;
    	TextView countryTextView;
    	TextView countryDetailTextView;
    }
    
    static class SectionHolder {
    	TextView sectionTitle;
    }
	
}
