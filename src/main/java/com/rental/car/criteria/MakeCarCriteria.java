package com.rental.car.criteria;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Repository;

import com.rental.car.model.Car;
@Repository
public class MakeCarCriteria implements ICriteria{
	private String make;
	public MakeCarCriteria() {
		// TODO Auto-generated constructor stub
	}
	
	

	public String getMake() {
		return make;
	}



	public void setMake(String make) {
		this.make = make;
	}



	public List<Car> meetCriteria(List<Car> cars) {
		List<Car> makeCars=new ArrayList<Car>();
		for(Car car : cars) {
			if(car.getMake().equalsIgnoreCase(this.make)) {
				makeCars.add(car);
			}
		}
		return makeCars;
	}
	
}
