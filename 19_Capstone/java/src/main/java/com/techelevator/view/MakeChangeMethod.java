package com.techelevator.view;

import java.math.BigDecimal;

public class MakeChangeMethod {
	
	public static BigDecimal makeChange(BigDecimal currentBalance) {
		int change = currentBalance.multiply(new BigDecimal(100)).intValue();
		int dollars = Math.round((int)change/100);
	    change=change%100;
	    int quarters = Math.round((int)change/25);
	    change=change%25;
	    int dimes = Math.round((int)change/10);
	    change=change%10;
	    int nickels = Math.round((int)change/5);
	    change=change%5;
	    int pennies = Math.round((int)change/1);
	   
	    currentBalance = new BigDecimal(0);
		System.out.println("Your change is: " + dollars + " dollars, " + quarters + " quarters, " + dimes + " dimes, " + nickels + " nickels and " + pennies + " pennies");
		return currentBalance;
	
	}

}
