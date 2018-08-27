package com.rental.car.model;

public class Car {
	private String make;
	private String model;
	private String vin;
	private MetaData metaData;
	private PerDayRent perDayRent;
	private Metrics metrics;
	
	public Car() {
		
	}	
	
	public Car(String make, String model, String vin, MetaData metaData, PerDayRent perDayRent, Metrics metrics) {
		super();
		this.make = make;
		this.model = model;
		this.vin = vin;
		this.metaData = metaData;
		this.perDayRent = perDayRent;
		this.metrics = metrics;
	}
	
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public MetaData getMetaData() {
		return metaData;
	}
	public void setMetaData(MetaData metaData) {
		this.metaData = metaData;
	}
	public PerDayRent getPerDayRent() {
		return perDayRent;
	}
	public void setPerDayRent(PerDayRent perDayRent) {
		this.perDayRent = perDayRent;
	}
	public Metrics getMetrics() {
		return metrics;
	}
	public void setMetrics(Metrics metrics) {
		this.metrics = metrics;
	}	
}
