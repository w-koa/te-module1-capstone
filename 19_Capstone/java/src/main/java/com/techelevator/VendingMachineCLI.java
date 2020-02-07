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
import com.techelevator.view.FileReader;
import com.techelevator.view.Gum;
import com.techelevator.view.Item;
import com.techelevator.view.Logger;
import com.techelevator.view.MakeChangeMethod;
import com.techelevator.view.Menu;
import com.techelevator.view.MenuConstants;

public class VendingMachineCLI {

	// read the file one line at time
	// determine what type of object
	// create the corresponding object for that type
	// load that object into an array or an arrayList

	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() throws IOException {

		List<Item> itemList = FileReader.fileReader();

		Scanner input = new Scanner(System.in);

		BigDecimal currentBalance = new BigDecimal(0.00);
		Logger logger = new Logger();

		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MenuConstants.MAIN_MENU_OPTIONS);

			if (choice.equals(MenuConstants.MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				FileReader.displayItems(itemList);

			} else if (choice.equals(MenuConstants.MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
				boolean purchaseMenu = true;
				while (purchaseMenu) {
					choice = (String) menu.getChoiceFromOptions(MenuConstants.PURCHASE_MENU_OPTIONS);

					if (choice.equals(MenuConstants.PURCHASE_MENU_OPTION_FEED_MONEY)) {

						boolean feedMenu = true;
						while (feedMenu) {
							choice = (String) menu.getChoiceFromOptions(MenuConstants.PURCHASE_MENU_FEED_OPTIONS);
							if (choice.equals(MenuConstants.PURCHASE_MENU_FEED_ONE_DOLLAR)) {
								logger.feedLogger(currentBalance, 1);
								currentBalance = currentBalance.add(new BigDecimal(1.00).setScale(2));
								System.out.println("Your current balance is now $" + currentBalance);

							} else if (choice.equals(MenuConstants.PURCHASE_MENU_FEED_TWO_DOLLARS)) {
								logger.feedLogger(currentBalance, 2);
								currentBalance = currentBalance.add(new BigDecimal(2.00));
								System.out.println("Your current balance is now $" + currentBalance);

							} else if (choice.equals(MenuConstants.PURCHASE_MENU_FEED_FIVE_DOLLARS)) {
								logger.feedLogger(currentBalance, 5);
								currentBalance = currentBalance.add(new BigDecimal(5.00));
								System.out.println("Your current balance is now $" + currentBalance);

							} else if (choice.equals(MenuConstants.PURCHASE_MENU_FEED_TEN_DOLLARS)) {
								logger.feedLogger(currentBalance, 10);
								currentBalance = currentBalance.add(new BigDecimal(10.00));
								System.out.println("Your current balance is now $" + currentBalance);
							} else if (choice.equals(MenuConstants.MENU_GO_BACK)) {
								feedMenu = false;
								choice = (String) menu.getChoiceFromOptions(MenuConstants.PURCHASE_MENU_OPTIONS); 
							}
						}

					}
					if (choice.equals(MenuConstants.PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
						FileReader.displayItems(itemList);
						System.out.println("");
						System.out.println("Select item: ");
						String select = input.nextLine();

						boolean itemFound = false;
						for (Item item : itemList) {
							if (item.getSlotLocation().equals(select)) {
								itemFound = true;
								if (item.getStock().equals("SOLD OUT")) {
									System.out.println("Sorry, item is SOLD OUT");
								} else if (currentBalance.compareTo(item.getPrice()) >= 0) {
									logger.purchaseLogger(currentBalance, item.getPrice(), item.getName(),
											item.getSlotLocation());
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
						if (!itemFound) {
							System.out.println("Selection is invalid");
						}

					} else if (choice.equals(MenuConstants.PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {

						MakeChangeMethod.makeChange(currentBalance);
						logger.changeLogger(currentBalance);
						currentBalance = new BigDecimal(0);
						purchaseMenu = false;

					} else if (choice.equals(MenuConstants.MENU_GO_BACK)) {
						purchaseMenu = false;
					}
					else if (choice.equals(MenuConstants.MAIN_MENU_OPTION_EXIT)) {

						choice = (String) menu.getChoiceFromOptions(MenuConstants.MAIN_MENU_OPTIONS);
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
