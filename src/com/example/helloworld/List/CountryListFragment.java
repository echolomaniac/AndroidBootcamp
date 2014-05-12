package com.example.helloworld.List;

import java.util.ArrayList;

import com.example.helloworld.R;
import com.example.helloworld.models.Country;
import com.example.helloworld.models.CountrySection;
import com.example.helloworld.models.builders.CountryBuilder;
import com.example.helloworld.models.builders.CountrySectionBuilder;

import android.app.AlertDialog;
import android.app.ListFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class CountryListFragment extends ListFragment {
	ListView countryList; 
	Country country;
	CountrySection section;
	String[] countriesArray = null;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		View rootView = inflater.inflate(R.layout.fragment_country_list, container, false);
		
		final String[] countries = getResources().getStringArray(R.array.list_countries);
		countriesArray = countries;
		final String[] icons = getResources().getStringArray(R.array.list_icons);
		final int[] resIDs = getIntIds(icons);
		final String[] continents = getResources().getStringArray(R.array.list_continents);
		
		int j = 0; //image counter
		int k = 0; //continent counter
		ArrayList data = new ArrayList();
		
		for(int i = 0; i < countries.length; i++) {
			if(countries[i].startsWith("section:")) {
				section = CountrySectionBuilder
						.countrySection()
						.withTitle(countries[i].toString())
						.build();
				data.add(section);
			}
			else {
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
			
		}
		
		
		CountryListAdapter adapter = new CountryListAdapter(getActivity().getApplicationContext(), data);
		setListAdapter(adapter);	
		
		return rootView;
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		
		//Toast.makeText(getActivity().getApplicationContext(), countriesArray[position].toString(), Toast.LENGTH_SHORT).show();
		// 1. Instantiate an AlertDialog.Builder with its constructor
		setAlertDialog(position);
	}
	
	public int[] getIntIds(String[] images){
	    int[] temp = new int[images.length];
	    for(int i=0; i< images.length; i++){
	        temp[i] = getResources().getIdentifier(images[i] , "drawable", getActivity().getPackageName());
	    }
	    return temp;
	}
	
	private void setAlertDialog(int position) {
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

		// 2. Chain together various setter methods to set the dialog characteristics
		builder.setMessage(countriesArray[position].toString())
		       .setTitle("Country");
		builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
	           public void onClick(DialogInterface dialog, int id) {
	               // User clicked OK button
	           }
	       });
		builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
	           public void onClick(DialogInterface dialog, int id) {
	               // User cancelled the dialog
	           }
	       });

		// 3. Get the AlertDialog from create()
		AlertDialog dialog = builder.create();
		dialog.show();
	}

}
