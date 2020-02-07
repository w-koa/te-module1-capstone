package com.techelevator.view;

import static org.junit.Assert.*;

import org.junit.Test;

public class ChipTest {
	
	String[] chips = {"A1", "Potato Crisps", "3.05", "Chip"};
	Item chipItem = new Chip(chips);

	@Test
	public void getSound_method_return_crunch_crunch_yum() {
		
		assertEquals("Crunch Crunch, YUM!", chipItem.getSound());
	}

}
