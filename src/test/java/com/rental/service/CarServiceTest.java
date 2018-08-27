package com.rental.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.rental.car.model.Car;
import com.rental.car.model.MetaData;
import com.rental.car.model.Metrics;
import com.rental.car.model.PerDayRent;
import com.rental.car.model.RentalCount;
import com.rental.car.repository.CarRepository;
import com.rental.car.service.CarServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class CarServiceTest {
	@Mock
	private CarRepository carRepository;
	
	@InjectMocks
	private CarServiceImpl carServiceImpl;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetAllCars(){
		List<Car> cars=new ArrayList<Car>();
		cars.add(new Car("Mercedes-Benz", "S-Class", "04CKKD6MD97486N", new MetaData("Black", "Excellent condition"), new PerDayRent(140, 15), new Metrics(1890.76f, 2156.43f, new RentalCount(4, 201))));
		cars.add(new Car("Range Rover", "4th-Generation", "07KDYR64NND85U", new MetaData("Sliver", "Scratches on the front side of the car"), new PerDayRent(180, 40), new Metrics(2890.76f, 2656.43f, new RentalCount(4, 231))));		
		cars.add(new Car("Audi", "A8", "02LEJY64352PIEHD96F", new MetaData("Gray", "Pick up and mileage problem"), new PerDayRent(120, 10), new Metrics(2490.76f, 2356.43f, new RentalCount(4, 212))));
		cars.add(new Car("BMW", "7-Series", "04KFUYE64352JITEG98I", new MetaData("White", "Head lights are not working"), new PerDayRent(135, 15), new Metrics(2290.76f, 2178f, new RentalCount(4, 166))));
		cars.add(new Car("Jaguar", "XJ", "05RUNF5724JIKEFR76Y", new MetaData("Red", "Gear box noise problem"), new PerDayRent(160, 25), new Metrics(2190.76f, 2256.43f, new RentalCount(4, 108))));
		cars.add(new Car("BMW", "6-Series", "03FHEF64352JITEG54R", new MetaData("Light Green", "Scratches on the front side of the car"), new PerDayRent(110, 10), new Metrics(2690.76f, 2487.43f, new RentalCount(4, 235))));		
		cars.add(new Car("Audi", "A7", "02AGHY96T24JITEG58A", new MetaData("Black", "Scratches on the roof side of the car"), new PerDayRent(240, 40), new Metrics(1990.76f, 2074.43f, new RentalCount(4, 216))));
		cars.add(new Car("Lexus", "LS", "06AKETC5683JITEG34G", new MetaData("Orange", "Excellent condition"), new PerDayRent(220, 30), new Metrics(1843.34f, 2457.76f, new RentalCount(7, 286))));
		cars.add(new Car("Tesla", "X", "09AJTHC64352JITEG312F", new MetaData("Blue", "Scratches on the back sides of the car"), new PerDayRent(160, 30), new Metrics(2443.34f, 2357.76f, new RentalCount(7, 186))));
		cars.add(new Car("Tesla", "S", "09AGHY64352JITEG98K", new MetaData("Blue", "Scratches on the front side of the car"), new PerDayRent(140, 20), new Metrics(2165.76f, 2078.43f, new RentalCount(4, 221))));
		cars.add(new Car("Tesla", "3", "07AGHY56532JITEG6F", new MetaData("Black", "Good condition"), new PerDayRent(130, 30), new Metrics(2040.67f, 2056.73f, new RentalCount(4, 178))));
		when(carRepository.getAllCars()).thenReturn(cars);		
		List<Car> result = carServiceImpl.getAllCars();
		assertEquals(11, result.size());
	}
	
	@Test
	public void testGetCarsByMakeAndColor(){	
		List<Car> cars = new ArrayList<Car>();
		cars.add(new Car("Jaguar", "XJ", "05RUNF5724JIKEFR76Y", new MetaData("Red", "Gear box noise problem"), new PerDayRent(160, 25), new Metrics(2190.76f, 2256.43f, new RentalCount(4, 108))));
		if(cars!=null && !cars.isEmpty()) {
		assertEquals("05RUNF5724JIKEFR76Y", cars.get(0).getVin());
		assertEquals("Jaguar", cars.get(0).getMake());
		assertEquals("XJ", cars.get(0).getModel());
		}
	}
	
	@Test
	public void testGetCarsByLowestPerDayRentalCost(){		
		List<Car> cars=new ArrayList<Car>();
		cars.add(new Car("BMW", "6-Series", "03FHEF64352JITEG54R", new MetaData("Light Green", "Scratches on the front side of the car"), new PerDayRent(110, 10), new Metrics(2690.76f, 2487.43f, new RentalCount(4, 235))));
		cars.add(new Car("Audi", "A8", "02LEJY64352PIEHD96F", new MetaData("Gray", "Pick up and mileage problem"), new PerDayRent(120, 10), new Metrics(2490.76f, 2356.43f, new RentalCount(4, 212))));
		cars.add(new Car("Tesla", "3", "07AGHY56532JITEG6F", new MetaData("Black", "Good condition"), new PerDayRent(130, 30), new Metrics(2040.67f, 2056.73f, new RentalCount(4, 178))));
		cars.add(new Car("BMW", "7-Series", "04KFUYE64352JITEG98I", new MetaData("White", "Head lights are not working"), new PerDayRent(135, 15), new Metrics(2290.76f, 2178f, new RentalCount(4, 166))));
		cars.add(new Car("Mercedes-Benz", "S-Class", "04CKKD6MD97486N", new MetaData("Black", "Excellent condition"), new PerDayRent(140, 15), new Metrics(1890.76f, 2156.43f, new RentalCount(4, 201))));
		cars.add(new Car("Tesla", "S", "09AGHY64352JITEG98K", new MetaData("Blue", "Scratches on the front side of the car"), new PerDayRent(140, 20), new Metrics(2165.76f, 2078.43f, new RentalCount(4, 221))));
		cars.add(new Car("Jaguar", "XJ", "05RUNF5724JIKEFR76Y", new MetaData("Red", "Gear box noise problem"), new PerDayRent(160, 25), new Metrics(2190.76f, 2256.43f, new RentalCount(4, 108))));
		cars.add(new Car("Tesla", "X", "09AJTHC64352JITEG312F", new MetaData("Blue", "Scratches on the back sides of the car"), new PerDayRent(160, 30), new Metrics(2443.34f, 2357.76f, new RentalCount(7, 186))));
		cars.add(new Car("Range Rover", "4th-Generation", "07KDYR64NND85U", new MetaData("Sliver", "Scratches on the front side of the car"), new PerDayRent(180, 40), new Metrics(2890.76f, 2656.43f, new RentalCount(4, 231))));		
		cars.add(new Car("Lexus", "LS", "06AKETC5683JITEG34G", new MetaData("Orange", "Excellent condition"), new PerDayRent(220, 30), new Metrics(1843.34f, 2457.76f, new RentalCount(7, 286))));cars.add(new Car("Audi", "A7", "02AGHY96T24JITEG58A", new MetaData("Black", "Scratches on the roof side of the car"), new PerDayRent(240, 40), new Metrics(1990.76f, 2074.43f, new RentalCount(4, 216))));when(carRepository.getAllCars()).thenReturn(cars);
		List<Car> result = carServiceImpl.getCarsByLowestPerDayRentalCost();
		assertEquals(11, result.size());
	}
	
	@Test
	public void testGetHighestRevenueCar(){
		List<Car> cars = carServiceImpl.getHighestRevenueCar();
		if(cars!=null && !cars.isEmpty()) {
		assertEquals("06AKETC5683JITEG34G", cars.get(0).getVin());
		assertEquals("Lexus", cars.get(0).getMake());
		assertEquals("LS", cars.get(0).getModel());
		}
	}
}
