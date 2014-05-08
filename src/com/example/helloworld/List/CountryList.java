package com.example.helloworld.List;



import java.util.ArrayList;

import com.example.helloworld.R;
import com.example.helloworld.models.Country;
import com.example.helloworld.models.CountryBuilder;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ListView;

public class CountryList extends ListActivity {
	ListView countryList; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.country_list);
		
		final String[] countries = getResources().getStringArray(R.array.list_countries);
		final String[] icons = getResources().getStringArray(R.array.list_icons);
		final int[] resIDs = getIntIds(icons);
		final String[] continents = getResources().getStringArray(R.array.list_continents);
		Country country;
		
		int j = 0; //image counter
		int k = 0; //continent counter
		ArrayList<Country> data = new ArrayList<Country>();
		for(int i = 0; i < countries.length; i++) {
			if(j<10) { //10 images
				if(k < 7) {
					country = CountryBuilder.country()
							.withIcon(resIDs[j])
							.withName(countries[i].toString())
							.withDetail(continents[k])
							.build();
					data.add(country);
					k++; //continent 
				}
				else {
					k = 0;
					
					country = CountryBuilder.country()
							.withIcon(resIDs[j])
							.withName(countries[i].toString())
							.withDetail(continents[k])
							.build();
					data.add(country);
				}
				
				j++; //image
			}
			else { //reset image counter = 0
				j = 0;
				
				country = CountryBuilder.country()
						.withIcon(resIDs[j])
						.withName(countries[i].toString())
						.withDetail(continents[k])
						.build();
				data.add(country);
			}
			
		}
		
		
		CountryListAdapter adapter = new CountryListAdapter(this,
				R.layout.listview_item_row, data);
		setListAdapter(adapter);	
		
		countryList =(ListView) findViewById(android.R.id.list);
		countryList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), countries[arg2].toString(), Toast.LENGTH_SHORT).show();
			}
			
		});
	}

	public int[] getIntIds(String[] images){
	    int[] temp = new int[images.length];
	    for(int i=0; i< images.length; i++){
	        temp[i] = getResources().getIdentifier(images[i] , "drawable", getPackageName());
	    }
	    return temp;
	}
	
	
	


}
