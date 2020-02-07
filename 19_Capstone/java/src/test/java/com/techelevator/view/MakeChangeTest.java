package com.techelevator.view;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.math.BigDecimal;

import org.junit.Test;

public class MakeChangeTest {

	MakeChangeMethod test = new MakeChangeMethod();
	
	@Test
	public void makeChange_for_1_dollar_returns_0() {
		BigDecimal currentBalance = new BigDecimal(1);
		BigDecimal expected = new BigDecimal(0);
		BigDecimal actual = test.makeChange(currentBalance);
		assertEquals(expected, actual);
	}

//	@Test
//	public void makeChange_for_1_dollar_has_4_quarters() {
//		BigDecimal currentBalance = new BigDecimal(1);
//		int actualQuarters = test.makeChange(currentBalance);
//		int expectedQuarters = 4;
//	}
}
