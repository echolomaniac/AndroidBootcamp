package com.example.helloworld.employee;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.helloworld.R;
import com.example.helloworld.models.Employee;
import com.example.helloworld.models.builders.EmployeeBuilder;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.Adapter;

public class EmployeeList extends ListActivity {
	ArrayList<String> fullname = new ArrayList<String>();
	String[] last = null;
	String[] first = null;
	int[] id = null;
	Employee employee;
	ArrayList<HashMap<Integer, Employee>> employees;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.employee_list);
		
		last = getResources().getStringArray(R.array.last_name_list);
		first = getResources().getStringArray(R.array.first_name_list);
		id = getResources().getIntArray(R.array.id_number_list);
		employees = new ArrayList<HashMap<Integer, Employee>>();
		
		fullname = setFullName();
		setEmployees();
		
		
	}
	
	private ArrayList<String> setFullName() {
		ArrayList<String> full = new ArrayList<String>();
		
		for(int i = 0; i < last.length; i++) {
			String name = last[i].concat(", ").concat(first[i]);
			
			full.add(name);
		}
		
		return full;
	}
	
	private void setEmployees() {
		
		for(int i = 0; i < id.length; i++) {
			HashMap<Integer, Employee> map = new HashMap<Integer, Employee>();
			
			employee = EmployeeBuilder.employee()
					.withFirstName(first[i])
					.withLastName(last[i])
					.withIdNumber(id[i])
					.build();
			
			map.put(id[i], employee);
			employees.add(map);
		}
	}

}
