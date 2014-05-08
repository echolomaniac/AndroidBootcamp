package com.example.helloworld;

import com.example.helloworld.List.CountryList;
import com.example.helloworld.askNumber.AskNumberActivity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends Activity {
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        if (savedInstanceState == null) {
        	 Fragment newFragment = new PlaceholderFragment();
             FragmentTransaction ft = getFragmentManager().beginTransaction();
             ft.add(R.id.container, newFragment).commit();
        }
    }
 
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
    	Button helloButton;
    	Button countryButton;
    	ImageButton numberButton;
    	EditText nameEditText;
    	
        public PlaceholderFragment() {
            
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            nameEditText = (EditText)rootView.findViewById(R.id.nameEditText);
            
        	countryButton = (Button)rootView.findViewById(R.id.listButton);
        	countryButton.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(getActivity(), CountryList.class);

		        	startActivity(intent);
				}
			});
        	

        	helloButton = (Button)rootView.findViewById(R.id.helloButton);
        	helloButton.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					//send input to another activity
		        	
		        	//get input from user
		        	String input = nameEditText.getText().toString();

		        	//put input in a bundle to be able to pass to an activity
		        	Bundle bundle = new Bundle();
		        	bundle.putString("name", input);

		        	//create intent
		        	Intent intent = new Intent(getActivity(), DisplayInputActivity.class);
		        	intent.putExtra("name", input);

		        	startActivity(intent);
				}
        		
        	});
        	
        	numberButton = (ImageButton)rootView.findViewById(R.id.france_icon);
        	numberButton.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					//create intent
		        	Intent intent = new Intent(getActivity(), AskNumberActivity.class);
		        	startActivity(intent);
				}
			});
        	
            return rootView;
        }
        

        public void onHelloPressed(View v) {
        	
        	
        }
        
        public void onCancelPressed(View v) {
        	
        }
    }

    
}
