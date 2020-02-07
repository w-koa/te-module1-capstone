package com.techelevator.view;

import java.math.BigDecimal;

public class MakeChangeMethod {
	
	public static BigDecimal makeChange(BigDecimal currentBalance) {
		int change = currentBalance.multiply(new BigDecimal(100)).intValue();
	    int quarters = Math.round((int)change/25);
	    change=change%25;
	    int dimes = Math.round((int)change/10);
	    change=change%10;
	    int nickels = Math.round((int)change/5);
	    change=change%5;
	  
	   
	    currentBalance = new BigDecimal(0);
		System.out.println("Your change is: " + quarters + " quarters, " 
	    + dimes + " dimes, and " + nickels + " nickels");
		return currentBalance;
	
	}
 
}
