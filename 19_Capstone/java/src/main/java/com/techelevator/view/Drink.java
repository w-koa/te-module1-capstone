package com.techelevator.view;

public class Drink extends Item {

	public Drink(String[] source) {
		super(source);
	}
	
	@Override
	public String getSound() {
		return "Glug Glug, YUM!";
	}


}
