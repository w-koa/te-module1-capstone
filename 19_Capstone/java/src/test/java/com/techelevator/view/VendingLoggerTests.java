package com.techelevator.view;

import static org.junit.Assert.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;

public class VendingLoggerTests {

	Logger test = new Logger();
	Date date= new Date();
	//getTime() returns current time in milliseconds
	long time = date.getTime();
	//Passed the milliseconds to constructor of Timestamp class 
	Timestamp ts = new Timestamp(time);
	
	@Test
	public void test() throws IOException {
		String actual = test.feedLogger(new BigDecimal(0), 1);
		String expected = ts + " FEED MONEY: $0 $1.00"; 
		assertEquals(expected, actual);
	}

}
