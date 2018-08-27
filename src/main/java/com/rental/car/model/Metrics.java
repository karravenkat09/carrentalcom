package com.rental.car.model;

public class Metrics {
	private float yoymaintenancecost;
	private float depreciation;
	private RentalCount rentalCount;
	
	public Metrics() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Metrics(float yoymaintenancecost, float depreciation, RentalCount rentalCount) {
		super();
		this.yoymaintenancecost = yoymaintenancecost;
		this.depreciation = depreciation;
		this.rentalCount = rentalCount;
	}


	public float getYoymaintenancecost() {
		return yoymaintenancecost;
	}
	public void setYoymaintenancecost(float yoymaintenancecost) {
		this.yoymaintenancecost = yoymaintenancecost;
	}
	public float getDepreciation() {
		return depreciation;
	}
	public void setDepreciation(float depreciation) {
		this.depreciation = depreciation;
	}
	public RentalCount getRentalCount() {
		return rentalCount;
	}
	public void setRentalCount(RentalCount rentalCount) {
		this.rentalCount = rentalCount;
	}
}
