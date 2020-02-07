package com.techelevator.view;

import static org.junit.Assert.*;

import org.junit.Test;

public class DrinkTest {

	String[] drink = {"C2", "Dr. Salt", "1.50", "Drink"};
	Item drinkItem = new Drink(drink);

	@Test
	public void getSound_method_return_glug_glug_yum() {
		
		assertEquals("Glug Glug, YUM!", drinkItem.getSound());
	}
}
