package com.techelevator.view;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;

public class ItemTests {

	String[] chips = {"A1", "Potato Crisps", "3.05", "Chip"};
	Item thing = new Chip(chips);
	
	
	@Test
	public void method_decrementStock_changesStock_returns_true_while_stock_5() {
		
		assertTrue(thing.decrementStock());
	}
	
	@Test
	public void method_decrementStock_1_returns_true() {
		String[] chips = {"A1", "Potato Crisps", "3.05", "Chip"};
		Item thing2 = new Chip(chips);
		thing2.decrementStock(); // 4
		thing2.decrementStock(); // 3
		thing2.decrementStock(); // 2
		thing2.decrementStock(); // 1
		assertTrue(thing2.decrementStock());
	}
	
	@Test
	public void getSlotLocation_returns_A1() {
		String actual = thing.getSlotLocation();
		String expected = "A1";
		assertEquals(expected, actual);
	}
	
	@Test
	public void get_productName_returns_Potato_Crisps() {
		String actual = thing.getName();
		String expected = "Potato Crisps";
		assertEquals(expected, actual);
	}
	
	@Test
	public void getPrice_returns_3_pt_05() {
		BigDecimal actual = thing.getPrice();
		BigDecimal expected = new BigDecimal("3.05");
		assertEquals(expected, actual);
	}
	
	@Test
	public void getType_returns_chips() {
		String actual = thing.getType();
		String expected = "Chip";
		assertEquals(expected, actual);
	}
	
	@Test
	public void getStock_returns_5_when_created() {
		String actual = thing.getStock();
		String expected = "5";
		assertEquals(expected, actual);
	}
	
	@Test
	public void getSound_for_chip_returns_Cruch_Cruch_Yum() {
		String actual = thing.getSound();
		String expected = "Crunch Crunch, YUM!";
		assertEquals(expected, actual);
	}
	
	@Test
	public void toString_method_returns_proper_string() {
		String actual = thing.toString();
		String expected = "A1    Potato Crisps            $3.05     Chip     5";
		assertEquals(expected, actual);
	}
}
