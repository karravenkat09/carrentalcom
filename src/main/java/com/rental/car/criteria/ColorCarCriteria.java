package com.rental.car.criteria;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.rental.car.model.Car;

@Repository
public class ColorCarCriteria implements ICriteria {
	private String color;
	
	public ColorCarCriteria() {
		// TODO Auto-generated constructor stub
	}
	
	

	public String getColor() {
		return color;
	}



	public void setColor(String color) {
		this.color = color;
	}


	public List<Car> meetCriteria(List<Car> cars) {
		List<Car> colorCars=new ArrayList<Car>();
		for(Car car : cars) {
			if(car.getMetaData().getColor().equalsIgnoreCase(this.color)) {
				colorCars.add(car);
			}
		}
		return colorCars;
	}

}
