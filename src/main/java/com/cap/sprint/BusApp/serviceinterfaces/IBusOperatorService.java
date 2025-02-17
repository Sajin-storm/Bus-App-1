package com.cap.sprint.BusApp.serviceinterfaces;

import java.time.LocalDate;

import com.cap.sprint.BusApp.entities.Bus;
import com.cap.sprint.BusApp.entities.BusOperator;

public interface IBusOperatorService {
	
	//Service methods to be implemented by Service Implementation Class
	
	public void addBus(Bus b);

	public int getRevenueByBusRoute(String routeName);
	
	public int getRevenueByBusRouteAndDate(String routeName, LocalDate date);
	
	public int getMonthlyRevenueByBusRoute(String routeName, String month, String year);
	
	public int getYearlyRevenueByBusRoute(String routeName, String year);
	
	public void addBusOperator(BusOperator busOp);
	
	public void updatePassword(String oldPassword, String newPassword);
}
