package com.example.helloworld.List;



import java.lang.reflect.Field;
import java.util.ArrayList;

import com.example.helloworld.R;
import com.example.helloworld.models.Country;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class CountryList extends ListActivity {
	ListView countryList; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.country_list);
		
		String[] countries = getResources().getStringArray(R.array.list_countries);
		String[] icons = getResources().getStringArray(R.array.list_icons);
		int[] resIDs = getIntIds(icons);
		String[] continents = getResources().getStringArray(R.array.list_continents);
		Country country;	
		
		
		int j = 0; //image counter
		int k = 0; //continent counter
		ArrayList<Country> data = new ArrayList<Country>();
		for(int i = 0; i < countries.length; i++) {
			if(j<10) { //10 images
				if(k < 7) {
					country = new Country(resIDs[j], countries[i].toString(), continents[k]);
					data.add(country);
					k++; //continent 
				}
				else {
					k = 0;
				}
				
				j++; //image
			}
			else { //reset image counter = 0
				j = 0;
			}
			
		}
		

		CountryListAdapter adapter = new CountryListAdapter(this,
				R.layout.listview_item_row, data);
		
		
		setListAdapter(adapter);
	}

	public int[] getIntIds(String[] images){
	    int[] temp = new int[images.length];
	    for(int i=0; i< images.length; i++){
	        temp[i] = getResources().getIdentifier(images[i] , "drawable", getPackageName());
	    }
	    return temp;
	}
	
	
	


}
