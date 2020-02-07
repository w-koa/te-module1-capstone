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
	 
	public String feedLogger(BigDecimal currentAmount, int feedAmount) throws IOException {
		FileWriter fileWriter = new FileWriter("log.txt", true);
		PrintWriter printWriter = new PrintWriter(fileWriter);
		printWriter.println(ts + " FEED MONEY: $" + currentAmount + " $" +
				currentAmount.add(new BigDecimal(feedAmount).setScale(2)));
	
		 printWriter.close();
		 return (ts + " FEED MONEY: $" + currentAmount + " $" +
					currentAmount.add(new BigDecimal(feedAmount).setScale(2)));
	}
	
	public void purchaseLogger(BigDecimal currentAmount, BigDecimal purchaseAmount, String itemName, String itemSlot) throws IOException {
		FileWriter fileWriter = new FileWriter("log.txt", true);
		PrintWriter printWriter = new PrintWriter(fileWriter);
		printWriter.println(ts + " " + itemName + " " + itemSlot + " $" + currentAmount +
				" $" + currentAmount.subtract(purchaseAmount.setScale(2)));
	
		 printWriter.close();
	}
	
	public void changeLogger(BigDecimal currentAmount) throws IOException {
		FileWriter fileWriter = new FileWriter("log.txt", true);
		PrintWriter printWriter = new PrintWriter(fileWriter);
		printWriter.println(ts + " GIVE CHANGE: $" + currentAmount + " $0.00");
	
		 printWriter.close();
	}
}
