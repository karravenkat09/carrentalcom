package com.rental.car.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;

import com.rental.car.model.Car;

public class ComparatorUtil {
	
	private static final SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
	
	/**
	 * Lowest per day rental cost means car which has less price and more discount.
	 * @return
	 */
	public static Comparator<Car> getLowestPerDayRentalCostCarComparator(){
		return new Comparator<Car>() {
			public int compare(Car car1, Car car2) {
				// TODO Auto-generated method stub
				if(car1!=null && car2!=null) {
					float car1Price=car1.getPerDayRent().getPrice();
					float car1Discount=car1.getPerDayRent().getDiscount();
					float car2Price=car2.getPerDayRent().getPrice();
					float car2Discount= car2.getPerDayRent().getDiscount();
					if(car1Price > car2Price && car1Price-car1Discount > car2Price - car2Discount  ) {
						return 1;
					}else if(car1Price < car2Price && car1Price - car1Discount <  car2Price-car2Discount)
					{
						return -1;
					}else {
						return 0;
					}					
				}else {
					return -1;
				}
			}			
		};
	}
	
	/**
	 * HighestRevenue car means which has less yoymaintaincecost and depreciation.
	 * @return
	 */
	
	public static Comparator<Car> getHighestRevenueCarComparator(){
		return new Comparator<Car>() {
			public int compare(Car car1, Car car2) {
				// TODO Auto-generated method stub
				if(car1!=null && car2!=null) {					
					float car1yoymntncecost=car1.getMetrics().getYoymaintenancecost();
					float car1Depreciation=car1.getMetrics().getDepreciation();
					float car2yoymntncecost=car2.getMetrics().getYoymaintenancecost();
					float car2Depreciation= car2.getMetrics().getDepreciation();
					if(car1yoymntncecost+car1Depreciation > car2yoymntncecost + car2Depreciation  ) {
						return 1;
					}else if(car1yoymntncecost+car1Depreciation < car2yoymntncecost + car2Depreciation)
					{
						return -1;
					}else {
						return 0;
					}					
				}else {
					return -1;
				}
			}			
		};
	}
	
	public static boolean isProfitsInLastYear(int yeartodate) {
		int nCalcYear=0;
		Calendar calendar=Calendar.getInstance();
		int currentYear=calendar.get(Calendar.YEAR);
		calendar.add(Calendar.DAY_OF_YEAR, -yeartodate);
		String calcYear=sdf.format(calendar.getTime());
		if(calcYear!=null && calcYear.trim().length()>0) {
			nCalcYear=Integer.parseInt(calcYear);		
		}
		return currentYear-nCalcYear==1?true:false;
	}
}
