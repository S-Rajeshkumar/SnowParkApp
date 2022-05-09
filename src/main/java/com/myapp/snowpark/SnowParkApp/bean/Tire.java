package com.myapp.snowpark.SnowParkApp.bean;

public class Tire {
    
    private String tireManufacturer;
	private int size;
	private int price;

	public Tire() {
		super();
	}

	public Tire(String tireManufacturer, int size, int price) {
		super();
		this.tireManufacturer = tireManufacturer;
		this.size = size;
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	public int getSize() {
		return size;
	}

	public String getTireManufacturer() {
		return tireManufacturer;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void setTireManufacturer(String tireManufacturer) {
		this.tireManufacturer = tireManufacturer;
	}

	@Override
	public String toString() {
		return "Tire [tireManufacturer=" + tireManufacturer + ", size=" + size + ", price=" + price + "]";
	}

}
