package com.techelevator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.techelevator.view.Candy;
import com.techelevator.view.Chip;
import com.techelevator.view.Drink;
import com.techelevator.view.Gum;
import com.techelevator.view.Item;
import com.techelevator.view.Logger;
import com.techelevator.view.Menu;

public class VendingMachineCLI {

	// read the file one line at time
	// determine what type of object
	// create the corresponding object for that type
	// load that object into an array or an arrayList

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE,
			MAIN_MENU_OPTION_EXIT };
	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY,
			PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION };
	private static final String PURCHASE_MENU_FEED_ONE_DOLLAR = "$1";
	private static final String PURCHASE_MENU_FEED_TWO_DOLLARS = "$2";
	private static final String PURCHASE_MENU_FEED_FIVE_DOLLARS = "$5";
	private static final String PURCHASE_MENU_FEED_TEN_DOLLARS = "$10";
	private static final String[] PURCHASE_MENU_FEED_OPTIONS = { PURCHASE_MENU_FEED_ONE_DOLLAR,
			PURCHASE_MENU_FEED_TWO_DOLLARS, PURCHASE_MENU_FEED_FIVE_DOLLARS, PURCHASE_MENU_FEED_TEN_DOLLARS };
	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() throws IOException {
		// read in the file
		String path = "vendingmachine.csv";
		File file = new File(path);
		Scanner fileScanner = new Scanner(file);
		Scanner input = new Scanner(System.in);
		
		FileWriter fileWriter = new FileWriter("log.txt", true);
		PrintWriter printWriter = new PrintWriter(fileWriter);

		// Date object
		Date date = new Date();
		// getTime() returns current time in milliseconds
		long time = date.getTime();
		// Passed the milliseconds to constructor of Timestamp class
		Timestamp ts = new Timestamp(time);
		System.out.println("Current Time Stamp: " + ts);

		List<Item> itemList = new ArrayList<Item>();

		while (fileScanner.hasNextLine()) {
			String line = fileScanner.nextLine();
			String[] lineArray = line.split("\\|");
			if (lineArray[3].equals("Chip")) {
				Item chips = new Chip(lineArray);
				itemList.add(chips);
			} else if (lineArray[3].equals("Candy")) {
				Item candy = new Candy(lineArray);
				itemList.add(candy);
			} else if (lineArray[3].equals("Drink")) {
				Item drink = new Drink(lineArray);
				itemList.add(drink);
			} else if (lineArray[3].equals("Gum")) {
				Item gum = new Gum(lineArray);
				itemList.add(gum);
			}
		}

		fileScanner.close();

		BigDecimal currentBalance = new BigDecimal(0.00);
		Logger logger = new Logger();

		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				System.out.println(String.format("%-5s %-20s     $%6s   %-8s %5s", "Slot", "Item Name", "Price", "Type",
						"Quantity"));
				System.out.println("==========================================================");
				for (Item item : itemList) {
					System.out.println(item.toString());
				}

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
				choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
				if (choice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
					choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_FEED_OPTIONS);
					if (choice.equals(PURCHASE_MENU_FEED_ONE_DOLLAR)) {
						logger.feedLogger(currentBalance, 1);
						currentBalance = currentBalance.add(new BigDecimal(1.00).setScale(2));
						System.out.println("Your current balance is now $" + currentBalance);

					} else if (choice.equals(PURCHASE_MENU_FEED_TWO_DOLLARS)) {
						printWriter.println(ts + " FEED MONEY: $" + currentBalance + " $"
								+ currentBalance.add(new BigDecimal(2.00).setScale(2)));
						currentBalance = currentBalance.add(new BigDecimal(2.00));
						System.out.println("Your current balance is now $" + currentBalance);

					} else if (choice.equals(PURCHASE_MENU_FEED_FIVE_DOLLARS)) {
						printWriter.println(ts + " FEED MONEY: $" + currentBalance + " $"
								+ currentBalance.add(new BigDecimal(5.00).setScale(2)));
						currentBalance = currentBalance.add(new BigDecimal(5.00));
						System.out.println("Your current balance is now $" + currentBalance);

					} else if (choice.equals(PURCHASE_MENU_FEED_TEN_DOLLARS)) {
						printWriter.println(ts + " FEED MONEY: $" + currentBalance + " $"
								+ currentBalance.add(new BigDecimal(10.00).setScale(2)));
						currentBalance = currentBalance.add(new BigDecimal(10.00));
						System.out.println("Your current balance is now $" + currentBalance);
					}

				}
				if (choice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
					System.out.println(String.format("%-5s %-20s     $%6s   %-8s %5s", "Slot", "Item Name", "Price",
							"Type", "Quantity"));
					System.out.println("==========================================================");
					for (Item item : itemList) {
						System.out.println(item.toString());

					}
					System.out.println("");
					System.out.println("Select item: ");
					String select = input.nextLine();
					
					for (Item item : itemList) {
						if (item.getSlotLocation().equals(select) && !item.getStock().equals("SOLD OUT")) {
							if (item.getStock().equals("SOLD OUT")) {
								System.out.println("Sorry, item is SOLD OUT");
							} else
							if (currentBalance.compareTo(item.getPrice()) >= 0) {
								currentBalance = currentBalance.subtract(item.getPrice());
								item.decrementStock();
								System.out.println();
								System.out.println(item.getSound());
								System.out.println("Your balance is now: " + currentBalance);
							} else if (currentBalance.compareTo(item.getPrice()) < 0) {
								System.out.println("You do not have enough money!");
							} 
						}
					}
					
				} else if(choice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)){
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
					
//					BigDecimal balanceInPennies = currentBalance.multiply(new BigDecimal(100));
//					BigDecimal dollars = balanceInPennies.divide(new BigDecimal(100));
//					balanceInPennies = balanceInPennies.subtract(dollars.multiply(new BigDecimal(100)));
//					BigDecimal quarters = balanceInPennies.divide(new BigDecimal(25));
//					balanceInPennies = balanceInPennies.subtract(dollars.multiply(new BigDecimal(25)));
//					BigDecimal dimes = balanceInPennies.divide(new BigDecimal(10));
//					balanceInPennies = balanceInPennies.subtract(dollars.multiply(new BigDecimal(10)));
//					BigDecimal nickels = balanceInPennies.divide(new BigDecimal(5));
//					balanceInPennies = balanceInPennies.subtract(dollars.multiply(new BigDecimal(5)));
//					BigDecimal pennies = balanceInPennies;
					System.out.println("Your change is: " + dollars + " dollars, " + quarters + " quarters, " + dimes + " dimes, " + nickels + " nickels and " + pennies + " pennies");

					
				}
				
				else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
					
					choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}

//	@SuppressWarnings("resource")
//	private static File getFileFromUser() {
//		Scanner userInput = new Scanner(System.in);
//		System.out.println("Please enter path to input file >>> ");
//		String path = userInput.nextLine();
//		
//		File inputFile = new File(path);
//		if (inputFile.exists() == false) {
//			System.out.println(path + " does not exist");
//			System.exit(1);
//		} else if (inputFile.isFile() == false) {
//			System.out.println(path + " is not a valid file");
//			System.exit(1);
//		}
//		return inputFile;
//	}
}
