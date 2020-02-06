package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachineDemo {

	public static void main(String[] args) throws IOException {
		
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
		
		fileScanner.close();
		String path2 = "log.txt";
		File file2 = new File(path2);
		if (file2.exists()) {
			System.out.println("File information: ");
			System.out.println("\tName: " + file2.getName());
			System.out.println("\tAbsolute Path: " + file2.getAbsolutePath());
			System.out.println("\tSize: " + file2.length());
			
			if (file2.isDirectory()) {
				System.out.println("\ttype: directory");
			}
			if (file2.isFile()) {
				System.out.println("\ttype: file");
			}
		} else {
			System.out.println("file does not exist");
		}
}
}

