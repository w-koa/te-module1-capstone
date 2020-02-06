package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.techelevator.view.Candy;
import com.techelevator.view.Chip;
import com.techelevator.view.Drink;
import com.techelevator.view.Gum;
import com.techelevator.view.Item;
import com.techelevator.view.Menu;

public class VendingMachineCLI {

	//read the file one line at time
			//determine what type of object
			// create the corresponding object for that type
			// load that object into an array or an arrayList
	
	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };
	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};
	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() throws FileNotFoundException {
		//read in the file
		String path = "vendingmachine.csv";
		File file = new File(path);
		Scanner fileScanner = new Scanner(file);
		List<Item> itemList = new ArrayList<Item>();
		
		while(fileScanner.hasNextLine()) {
			String line = fileScanner.nextLine();
			String [] lineArray = line.split("\\|");
			if (lineArray[3].equals("Chip")) {
				Item chips = new Chip(lineArray);
				itemList.add(chips);
			} else if (lineArray[3].equals("Candy")) {
				Item candy = new Candy(lineArray);
				itemList.add(candy);
			} else if (lineArray[3].equals("Drink")) {
				Item drink = new Drink(lineArray);
				itemList.add(drink);
			}else if (lineArray[3].equals("Gum")) {
				Item gum = new Gum(lineArray);
				itemList.add(gum);
			}
		}
		
		fileScanner.close();
	
			
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				System.out.println(String.format("%-5s %-20s     $%6s   %-8s %5s",
						"Slot", "Item Name", "Price", "Type", "Quantity"));
				System.out.println("==========================================================");
				for (Item item : itemList) {
					System.out.println(item.toString());
				}
				
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
				choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			}
		}
}

	public static void main(String[] args) throws FileNotFoundException {
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
