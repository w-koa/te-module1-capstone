package com.techelevator.view;

public class Chips extends Item{

	public Chips(String[] source) {
		super(source);
	}
	
	@Override
	public String getSound() {
		return "Crunch Crunch, YUM!";
	}

}
