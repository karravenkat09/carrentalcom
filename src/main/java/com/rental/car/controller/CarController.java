package com.rental.car.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rental.car.exception.CarNotFoundException;
import com.rental.car.model.Car;
import com.rental.car.service.CarService;

@RestController
public class CarController {
	private static final Logger logger = LoggerFactory.getLogger(CarController.class);
	@Autowired
	private CarService carService;
	
	@RequestMapping(value="/cars", method=RequestMethod.GET)
	public ResponseEntity<List<Car>> getAllCars() throws CarNotFoundException{
		logger.info("Returning all the Car´s");
		List<Car> cars=carService.getAllCars();
		if(cars==null || cars.isEmpty()) {
			throw new CarNotFoundException("No cars exist in car rental company");
		}
		return new ResponseEntity<List<Car>>(cars, HttpStatus.OK);
	}
	
	@RequestMapping(value="/cars/{color}/{make}", method=RequestMethod.GET)
	public ResponseEntity<List<Car>> getCarsByMakeAndColor(@PathVariable("color") String color, @PathVariable("make") String make) throws CarNotFoundException
	{
		logger.info("Returning the criteria mathced Car´s");
		List<Car> cars=carService.getCarsByMakeAndColor(make, color);
		if(cars==null || cars.isEmpty()) {
			throw new CarNotFoundException("No cars exist with the given criteria, color : "+color+", make : "+make);
		}
		return new ResponseEntity<List<Car>>(cars, HttpStatus.OK);
	}
	
	@RequestMapping(value="/cars/getlowestrentalcost", method=RequestMethod.GET)
	public ResponseEntity<List<Car>> getLowestPerDayRentalCostCars() throws CarNotFoundException{
		logger.info("Returning the getLowestPerDayRentalCostCars");
		List<Car> cars=carService.getCarsByLowestPerDayRentalCost();
		if(cars==null || cars.isEmpty()) {
			throw new CarNotFoundException("Lowest per day rental cost cars are not available in the rental company");
		}
		return new ResponseEntity<List<Car>>(cars, HttpStatus.OK);
	}
	
	@RequestMapping(value="/cars/gethighestprofitinlastyear", method=RequestMethod.GET)
	public ResponseEntity<List<Car>> getHighestRevenueCar() throws CarNotFoundException{
		logger.info("Returning highest revenue car");
		List<Car> cars=carService.getHighestRevenueCar();
		if(cars==null || cars.isEmpty()) {
			throw new CarNotFoundException("Highest profit generated cars are not available in last year");
		}
		return new ResponseEntity<List<Car>>(cars, HttpStatus.OK);
	}
}
