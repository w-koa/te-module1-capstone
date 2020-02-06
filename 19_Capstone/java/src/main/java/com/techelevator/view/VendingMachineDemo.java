package com.techelevator.view;

public class VendingMachineDemo {

	public static void main(String[] args) {
		
		String [] array = {"A1", "Chips", "2.99", "chips"};

		Item chips = new Chips(array);
		
		chips.getDispenseSound();
		
		System.out.println(chips.getName());
		System.out.println(chips.getSlotLocation());
		System.out.println(chips.getStock());
		System.out.println(chips.getType());
		System.out.println(chips.getPrice());
		

}
}

