package com.rental.car.criteria;

import java.util.List;

import com.rental.car.model.Car;

/**
 * By using this interface we are implemening filter design pattern and its combines the multiple criterias into single creteria.
 * @author venkat.m
 *
 */
public interface ICriteria {
	public List<Car> meetCriteria(List<Car> cars);
}
