package com.example.helloworld.models;

public class Country {
	public String name;
	public int icon;
	public String detail;
	
	public Country() {
		super();
	}
	
	public Country(int icon, String name, String detail) {
		super();
		this.icon = icon;
		this.name = name;
		this.detail = detail;
	}
}
