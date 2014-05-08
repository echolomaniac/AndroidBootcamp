package com.example.helloworld.askNumber;

import com.example.helloworld.R;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AskNumberActivity extends Activity {
	Button okayButton;
	EditText numberTextField;
	TextView displayValue;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ask_number);
		
		numberTextField = (EditText)findViewById(R.id.number_edit_text);
		displayValue = (TextView)findViewById(R.id.display_text_view);
		
		okayButton = (Button)findViewById(R.id.ok_button);
		okayButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				int value = getEnteredValue();
				Resources res = getResources();
				String output = res.getQuantityString(R.plurals.ask_for_a_number, value, value);
				
				displayValue.setText(output);
				
			}
		});
		
	}
	
	private int getEnteredValue() {
		int value = 0;
		value = Integer.parseInt(numberTextField.getText().toString());
		
		return value;
		
	}

}
