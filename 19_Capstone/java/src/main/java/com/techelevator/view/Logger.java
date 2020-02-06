package com.techelevator.view;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class Logger {
	
	
	//Date object
	 Date date= new Date();
        //getTime() returns current time in milliseconds
	 long time = date.getTime();
        //Passed the milliseconds to constructor of Timestamp class 
	 Timestamp ts = new Timestamp(time);
//	 System.out.println("Current Time Stamp: "+ts);
	 
	public void feedLogger(BigDecimal amount, int feedAmount) throws IOException {
		FileWriter fileWriter = new FileWriter("log.txt", true);
		PrintWriter printWriter = new PrintWriter(fileWriter);
		printWriter.println(ts + " FEED MONEY: $" + amount + " $" +
				amount.add(new BigDecimal(feedAmount).setScale(2)));
	
		 
		 
	}
}
