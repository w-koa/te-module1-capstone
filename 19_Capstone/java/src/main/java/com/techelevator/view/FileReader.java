package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
	
	public static List<Item> fileReader() throws FileNotFoundException{
		
	String path = "vendingmachine.csv";
	File file = new File(path);
	Scanner fileScanner = new Scanner(file);

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
	} fileScanner.close();
	
	return itemList;

	}
	
	
	public static void displayItems(List <Item> itemList) {
		System.out.println(String.format("%-5s %-20s     $%6s   %-8s %5s", "Slot", "Item Name", "Price", "Type",
				"Quantity"));
		System.out.println("==========================================================");
		for (Item item : itemList) {
			System.out.println(item.toString());
		}
		
	}
}
