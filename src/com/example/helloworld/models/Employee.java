package com.example.helloworld.models;

public class Employee {
	private String firstName;
	private String lastName;
	private int idNumber;
	
	public Employee(String first, String last, int id) {
		super();
		this.setFirstName(first);
		this.setLastName(last);
		this.setIdNumber(id);
	}
	
	public Employee() {
		super();
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}
}
