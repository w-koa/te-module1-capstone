package com.techelevator.view;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

public class Logger {

	 LocalDateTime date= LocalDateTime.now();

	 String hours = Integer.toString(date.getHour());
	 String minutes = Integer.toString(date.getMinute());
	 String seconds = Integer.toString(date.getSecond());
	 String time = hours + ":" + minutes + ":" + seconds;
	 
	 String year = Integer.toString(date.getYear());
	 String month = Integer.toString(date.getMonthValue());
	 String day = Integer.toString(date.getDayOfMonth());
	 String dateFormat = month + "-" + day + "-" + year;
	public String feedLogger(BigDecimal currentAmount, int feedAmount) throws IOException {
		FileWriter fileWriter = new FileWriter("log.txt", true);
		PrintWriter printWriter = new PrintWriter(fileWriter);
		printWriter.println(dateFormat + " " + time + " FEED MONEY: $" + currentAmount + " $" +
				currentAmount.add(new BigDecimal(feedAmount).setScale(2)));
	
		 printWriter.close();
		 return (dateFormat + " " + time + " FEED MONEY: $" + currentAmount + " $" +
					currentAmount.add(new BigDecimal(feedAmount).setScale(2)));
	}
	
	public String purchaseLogger(BigDecimal currentAmount, BigDecimal purchaseAmount, String itemName, String itemSlot) throws IOException {
		FileWriter fileWriter = new FileWriter("log.txt", true);
		PrintWriter printWriter = new PrintWriter(fileWriter);
		printWriter.println(dateFormat + " " + time + " " + itemName + " " + itemSlot + " $" + currentAmount +
				" $" + currentAmount.subtract(purchaseAmount.setScale(2)));
	
		 printWriter.close();
		 return dateFormat + " " + time + " " + itemName + " " + itemSlot + " $" + currentAmount +
					" $" + currentAmount.subtract(purchaseAmount.setScale(2));
	} 
	  
	public String changeLogger(BigDecimal currentAmount) throws IOException {
		FileWriter fileWriter = new FileWriter("log.txt", true);
		PrintWriter printWriter = new PrintWriter(fileWriter);
		printWriter.println(time + " GIVE CHANGE: $" + currentAmount + " $0");
	
		 printWriter.close();
		 return time + " GIVE CHANGE: $" + currentAmount + " $0";
	}
}
