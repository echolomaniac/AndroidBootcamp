package com.example.helloworld.models;

import com.example.helloworld.List.Item;

public class Country implements Item {
	private String name;
	private int icon;
	private String detail;
	
	public Country() {
		super();
	}
	
	public Country(int icon, String name, String detail) {
		super();
		this.setIcon(icon);
		this.setName(name);
		this.setDetail(detail);
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public int getIcon() {
		return icon;
	}

	public void setIcon(int icon) {
		this.icon = icon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Boolean isSection() {
		// TODO Auto-generated method stub
		return false;
	}
}
