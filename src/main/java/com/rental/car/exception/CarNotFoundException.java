package com.rental.car.exception;

public class CarNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	private String errorMessage;
	
	public String getErrorMessage() {
		return errorMessage;
	}

	public CarNotFoundException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public CarNotFoundException() {
		super();
	}
}
