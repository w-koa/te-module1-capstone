package com.techelevator.view;

import java.util.Scanner;

public class UserInputScanner {
	
	static Scanner input = new Scanner(System.in);
	
	public static String scanner() {
	System.out.println("Select item: ");
	String selection = input.nextLine();
	input.close();
	return selection;
	}

}
