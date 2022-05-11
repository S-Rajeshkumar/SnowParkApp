package com.myapp.snowpark.SnowParkApp.bean;

import java.time.LocalDate;
import java.util.List;

public class Car {
    
	private String id;
	private String brand;
	private String color;
	private String type;
	private int startingPrice;
	private int endingPrice;
	private boolean available;
	private LocalDate firstReleaseDate;
	private List<String> additionalFeatures;
	private Engine engine;
	private List<Tire> tires;

	public Car() {
		super();
	}

	public int getEndingPrice() {
		return endingPrice;
	}

	public void setEndingPrice(int endingPrice) {
		this.endingPrice = endingPrice;
	}

	public Car(String brand, String color, String type) {
		super();
		this.brand = brand;
		this.color = color;
		this.type = type;
	}

	public List<String> getAdditionalFeatures() {
		return additionalFeatures;
	}

	public String getBrand() {
		return brand;
	}

	public String getColor() {
		return color;
	}

	public Engine getEngine() {
		return engine;
	}

	public LocalDate getFirstReleaseDate() {
		return firstReleaseDate;
	}

	public String getId() {
		return id;
	}

	public int getStartingPrice() {
		return startingPrice;
	}

	public List<Tire> getTires() {
		return tires;
	}

	public String getType() {
		return type;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAdditionalFeatures(List<String> additionalFeatures) {
		this.additionalFeatures = additionalFeatures;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public void setFirstReleaseDate(LocalDate firstReleaseDate) {
		this.firstReleaseDate = firstReleaseDate;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setStartingPrice(int startingPrice) {
		this.startingPrice = startingPrice;
	}

	public void setTires(List<Tire> tires) {
		this.tires = tires;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Car [additionalFeatures=" + additionalFeatures + ", available=" + available + ", brand=" + brand
				+ ", color=" + color + ", endingPrice=" + endingPrice + ", engine=" + engine + ", firstReleaseDate="
				+ firstReleaseDate + ", id=" + id + ", startingPrice=" + startingPrice + ", tires=" + tires + ", type="
				+ type + "]";
	}

}
