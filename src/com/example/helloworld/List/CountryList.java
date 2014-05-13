package com.example.helloworld.List;



import com.example.helloworld.R;
import com.example.helloworld.List.CountryListFragment.CountryListFragmentInterface;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class CountryList extends Activity implements CountryListFragmentInterface {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.country_list);
	}
	
	  
    @Override
    protected void onSaveInstanceState(Bundle outState) {
    	// TODO Auto-generated method stub
    	super.onSaveInstanceState(outState);
    	
    	Log.v("onSaveInstanceState", ""+outState);
    }
    
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	super.onRestoreInstanceState(savedInstanceState);
    	Log.v("onRestoreInstanceState", ""+savedInstanceState);
    }
    @Override
    protected void onStart() {
    	// TODO Auto-generated method stub
    	super.onStart();
    	Log.v("onStart", "onStart");
    }
    
    @Override
    protected void onRestart() {
    	// TODO Auto-generated method stub
    	super.onRestart();
    	Log.v("onRestart", "onRestart");
    }
    
    @Override
    protected void onResume() {
    	// TODO Auto-generated method stub
    	super.onResume();
    	Log.v("onResume", "onResume");
    }
    
    @Override
    protected void onPause() {
    	// TODO Auto-generated method stub
    	super.onPause();
    	Log.v("onPause", "onPause");
    }
    
    @Override
    protected void onStop() {
    	// TODO Auto-generated method stub
    	super.onStop();
    	Log.v("onStop", "onStop");
    }
 
    @Override
    protected void onDestroy() {
    	// TODO Auto-generated method stub
    	super.onDestroy();
    	Log.v("onDestroy", "onDestroy");
    }
    

	@Override
	public void onItemClick(String name, String details) {
		// TODO Auto-generated method stub
		CountryDetailsFragment detailFragment = (CountryDetailsFragment) getFragmentManager().findFragmentById(R.id.fragment2);
		
		if(detailFragment != null) {
			detailFragment.setCountryDetails(name, details);
		}
	}

}
