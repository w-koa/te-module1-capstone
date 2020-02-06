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

	
	public void decrementStock() {
		int intStock = Integer.parseInt(this.stock);
		if(intStock > 1) {
			intStock --;
			this.stock = Integer.toString(intStock);
		} else { 
			this.stock = "SOLD OUT";
		}
//		if (this.stock > 0) {
//			this.stock--;
//			String stockString = Integer.toString(this.stock);
//			return stockString;
//		} else return "SOLD OUT"
		
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
}
