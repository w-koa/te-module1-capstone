package com.techelevator.view;

import static org.junit.Assert.*;

import org.junit.Test;

public class CandyTest {

	String[] candy = {"B1", "Moonpie", "1.80", "Candy"};
	Item candyItem = new Candy(candy);
	
	@Test
	public void getSound_method_return_munch_munch_yum() {
		
		assertEquals("Munch Munch, YUM!", candyItem.getSound());
	}

}
