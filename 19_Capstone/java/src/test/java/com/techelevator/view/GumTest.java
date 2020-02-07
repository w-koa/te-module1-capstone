package com.techelevator.view;

import static org.junit.Assert.*;

import org.junit.Test;

public class GumTest {

	String[] gum = {"D1", "U-Chews", "0.85", "Gum"};
	Item gumItem = new Gum(gum);

	@Test
	public void getSound_method_return_chew_chew_yum() {
		
		assertEquals("Chew Chew, YUM!", gumItem.getSound());
	}
}
