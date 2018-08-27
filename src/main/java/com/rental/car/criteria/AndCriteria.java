package com.rental.car.criteria;

import java.util.List;


import com.rental.car.model.Car;

public class AndCriteria implements ICriteria{
	private ICriteria criteria;
	private ICriteria otherCriteria;	
	

	public AndCriteria(ICriteria criteria, ICriteria otherCriteria) {
		super();
		this.criteria = criteria;
		this.otherCriteria = otherCriteria;
	}



	public List<Car> meetCriteria(List<Car> cars) {
		List<Car> firstcriteria=criteria.meetCriteria(cars);
		return otherCriteria.meetCriteria(firstcriteria);
	}
	
}
