package com.example.helloworld.models;

import com.example.helloworld.List.Item;

public class CountrySection implements Item {
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public Boolean isSection() {
		// TODO Auto-generated method stub
		return true;
		
	}
}
