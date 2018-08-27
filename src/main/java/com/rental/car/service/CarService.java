package com.rental.car.service;

import java.util.List;

import com.rental.car.model.Car;

public interface CarService {
	public List<Car> getAllCars();
	
	public List<Car> getCarsByMakeAndColor(String make, String color);
	public List<Car> getCarsByLowestPerDayRentalCost();
	public List<Car> getHighestRevenueCar();
	
}
