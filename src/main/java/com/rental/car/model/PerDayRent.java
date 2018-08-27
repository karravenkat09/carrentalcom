package com.rental.car.model;

public class PerDayRent {
	private float price;
	private float discount;
	
	public PerDayRent() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public PerDayRent(float price, float discount) {
		super();
		this.price = price;
		this.discount = discount;
	}



	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
}
