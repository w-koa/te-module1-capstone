package com.techelevator.view;

public class Candy extends Item {

	public Candy(String[] source) {
		super(source);
	}
	
	@Override
	public String getSound() {
		return "Munch Munch, YUM!";
	}

}
