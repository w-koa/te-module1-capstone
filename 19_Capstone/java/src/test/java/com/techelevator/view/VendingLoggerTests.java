package com.techelevator.view;

import static org.junit.Assert.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import org.junit.Test;

public class VendingLoggerTests {

	Logger test = new Logger();
	LocalDateTime date= LocalDateTime.now();

	 String hours = Integer.toString(date.getHour());
	 String minutes = Integer.toString(date.getMinute());
	 String seconds = Integer.toString(date.getSecond());
	 String time = hours + ":" + minutes + ":" + seconds;
	
	@Test
	public void feedLogger_method_prints_0_dollar_current_balance_and_1_dollar_new_balance() throws IOException {
		String actual = test.feedLogger(new BigDecimal(0), 1);
		String expected = time + " FEED MONEY: $0 $1.00"; 
		assertEquals(expected, actual);
	}
	
	@Test
	public void purchaseLogger_method_prints_1_dollar_current_amount_and_25_cent_balance() throws IOException {
		String actual = test.purchaseLogger(new BigDecimal(1).setScale(2), new BigDecimal(.75), "Triplemint", "D4");
		String expected = time + " Triplemint D4 $1.00 $0.25"; 
		assertEquals(expected, actual);
	}

	@Test
	public void changeLogger_method_65_cents_prints_two_quarters_one_dime_and_one_nickel() throws IOException {
		String actual = test.changeLogger(new BigDecimal("0.65"));
		String expected = time + " GIVE CHANGE: $0.65 $0"; 
		assertEquals(expected, actual);
	}
}
