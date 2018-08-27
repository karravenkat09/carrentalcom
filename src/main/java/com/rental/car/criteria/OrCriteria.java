package com.rental.car.criteria;

import java.util.List;


import com.rental.car.model.Car;

public class OrCriteria implements ICriteria{
	private ICriteria criteria;
	private ICriteria otherCriteria;
	
	public OrCriteria(ICriteria criteria, ICriteria otherCriteria) {
		super();
		this.criteria = criteria;
		this.otherCriteria = otherCriteria;
	}
	public List<Car> meetCriteria(List<Car> cars) {
		List<Car> firstCriteriaCars=meetCriteria(cars);
		List<Car> secondCriteriaCars=meetCriteria(cars);
		
		for(Car car : secondCriteriaCars) {
			if(!firstCriteriaCars.contains(car)) {
				firstCriteriaCars.add(car);
			}
		}
		return firstCriteriaCars;
	}
	
	
}
