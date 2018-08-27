package com.rental.car.model;

public class MetaData {
	private String color;
	private String notes;
	
	public MetaData() {
		
	}	
	
	public MetaData(String color, String notes) {
		super();
		this.color = color;
		this.notes = notes;
	}

	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}	
	
}
