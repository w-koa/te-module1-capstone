package com.techelevator.view;

public class Gum extends Item {

	public Gum(String[] source) {
		super(source);
	}
	
	@Override
	public String getSound() {
		return "Chew Chew, YUM!";
	}


}
