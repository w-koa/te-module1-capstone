package com.techelevator.view;

public class Chip extends Item{

	public Chip(String[] source) {
		super(source);
	}
	
	@Override
	public String getSound() {
		return "Crunch Crunch, YUM!";
	}

}
