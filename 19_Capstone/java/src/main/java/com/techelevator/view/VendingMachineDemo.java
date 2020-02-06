package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachineDemo {

	public static void main(String[] args) throws FileNotFoundException {
		
		String [] array = {"A1", "Cloud popconrs", "2.99", "chips"};

//		Item chips = new Chips(array);
//		
//		
//		System.out.println(chips.getName());
//		System.out.println(chips.getSlotLocation());
//		System.out.println(chips.getStock());
//		System.out.println(chips.getType());
//		System.out.println(chips.getPrice());
//		System.out.println(chips.getSound());
//		System.out.println(chips.getSound());
//		System.out.println(chips.toString());
//		
		String path = "vendingmachine.csv";
		File file = new File(path);
		
		Scanner fileScanner = new Scanner(file);

		List<Item> itemList = new ArrayList<Item>();
		
		while(fileScanner.hasNextLine()) {
			String line = fileScanner.nextLine();
			String [] lineArray = line.split("|");
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
		
		for (Item item : itemList) {
			System.out.println(drink.toString());
		}
		
		fileScanner.close();
		
		
}
}

