package com.example.helloworld.employee;

import java.util.HashMap;
import java.util.List;

import com.example.helloworld.R;
import com.example.helloworld.models.Employee;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class EmployeeListSimpleAdapter extends SimpleAdapter {
	Context context;
	List<? extends HashMap<String, ?>> data;
	int resource;
	String[] from;
	int[] to;

	public EmployeeListSimpleAdapter(Context context,
			List<? extends HashMap<String, ?>> data, int resource, String[] from,
			int[] to) {
		super(context, data, resource, from, to);
		// TODO Auto-generated constructor stub
		this.context = context;
		this.data = data;
		this.resource = resource;
		this.from = from;
		this.to = to;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Employee employee;
		View row = convertView;
		EmployeeHolder holder = null;
		HashMap<String, Employee> emp;
		
		LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		if(holder == null) {
			row = inflater.inflate(R.layout.employee_row_item, parent, false);
			holder = new EmployeeHolder();
			holder.firsNameTextView = (TextView)row.findViewById(R.id.employee_name);
			holder.idNUmberTextView = (TextView)row.findViewById(R.id.employee_number);
			
			emp = (HashMap<String, Employee>) getItem(position);
			employee = emp.get("name");
			holder.firsNameTextView.setText(employee.getFirstName());
			holder.idNUmberTextView.setText(""+employee.getIdNumber());
			
			row.setTag(holder);
		} else {
			holder = (EmployeeHolder)row.getTag();
		}
		
		return row;
	}
	
	static class EmployeeHolder {
		TextView firsNameTextView;
		TextView lastNameTextView;
		TextView idNUmberTextView;
	}

}
