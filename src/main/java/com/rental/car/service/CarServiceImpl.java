package com.rental.car.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.rental.car.criteria.AndCriteria;
import com.rental.car.criteria.ColorCarCriteria;
import com.rental.car.criteria.ICriteria;
import com.rental.car.criteria.MakeCarCriteria;
import com.rental.car.model.Car;
import com.rental.car.repository.CarRepository;
import com.rental.car.util.ComparatorUtil;

@Service("carService")
public class CarServiceImpl implements CarService{

	@Autowired
	private CarRepository carRepository;
	@Autowired	@Qualifier(value = "colorCarCriteria")
	private ICriteria colorCarCriteria;
	@Autowired	@Qualifier(value = "makeCarCriteria")
	private ICriteria makeCarCriteria;	
	
	/**
	 * Used for retrieving all the cars in the car rental company
	 */
	public List<Car> getAllCars() {
		// TODO Auto-generated method stub
		return carRepository.getAllCars();
	}
	
	
	/**
	 * Used for retrieving the cars by passing specific color & make
	 */
	public List<Car> getCarsByMakeAndColor(String make, String color) {
		((ColorCarCriteria)colorCarCriteria).setColor(color);
		((MakeCarCriteria)makeCarCriteria).setMake(make);
		ICriteria colorMakeCarCriteria = new AndCriteria(colorCarCriteria, makeCarCriteria);
		List<Car> colorMakeCars= colorMakeCarCriteria.meetCriteria(getAllCars());
		return colorMakeCars;
	}
	
	/**
	 * Used for get the cars based on lowest per day rental cost
	 */
	public List<Car> getCarsByLowestPerDayRentalCost(){
		List<Car> cars=getAllCars();
		Collections.sort(cars, ComparatorUtil.getLowestPerDayRentalCostCarComparator());		
		return cars;
	}
	
	/**
	 * Used for get the cars having higest profits in last year
	 */
	public List<Car> getHighestRevenueCar() {
		List<Car> lastYearHighestProfitCars=null;
		List<Car> cars=getAllCars();
		Collections.sort(cars, ComparatorUtil.getHighestRevenueCarComparator());
		lastYearHighestProfitCars=new ArrayList<Car>();
		for(Car car : cars) {			
			if(ComparatorUtil.isProfitsInLastYear(car.getMetrics().getRentalCount().getYeartodate())) {
				lastYearHighestProfitCars.add(car);
			}
		}
		return lastYearHighestProfitCars;
	}	
	
}
