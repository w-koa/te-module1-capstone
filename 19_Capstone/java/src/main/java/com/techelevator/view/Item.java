package com.techelevator.view;
import java.math.BigDecimal;

public abstract class Item implements DispensingSound {

	// Attributes
	private String slotLocation;
	private String name;
	private BigDecimal price;
	private String type;
	private String stock;
	private String sound;
	
	// Constructor takes string array from line read.
	
	public Item(String sound) {
		this.sound = sound; 
	}
	public Item(String[] source) {
		this.slotLocation = source[0];
		this.name = source[1];
		this.price = new BigDecimal(source[2]);
		this.type = source[3];
		this.stock = "5";
		this.sound = "";
	}
 
	
	public boolean decrementStock() {
		boolean changedStock = false;
		int intStock = Integer.parseInt(this.stock);
		if(intStock > 1) {
			intStock --;
			this.stock = Integer.toString(intStock);
			changedStock = true;
		} else if (intStock == 1) { 
			this.stock = "SOLD OUT";
			changedStock = true;
		} return changedStock;		
	}
	
	
	
	// Getters
	public String getSlotLocation() {
		return slotLocation;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public String getType() {
		return type;
	}

	public String getStock() {
		return stock;
	}

	@Override
	public String getSound() {
		return sound;
	}
	
	@Override
	public String toString() {
		return String.format("%-5s %-20s     $%.2f     %-5s %4s", this.slotLocation, this.name, this.price 
				, this.type, this.stock);
	}
}
