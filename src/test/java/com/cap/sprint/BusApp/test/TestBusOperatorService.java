package com.cap.sprint.BusApp.test;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cap.sprint.BusApp.entities.Bus;
import com.cap.sprint.BusApp.entities.BusOperator;
import com.cap.sprint.BusApp.services.IBusOperatorService;

@SpringBootTest
class TestBusOperatorService {

	@Autowired
	IBusOperatorService busOperatorService;
	
	@Test
	void addBus() {
		Bus b = new Bus("1111", 21, 10, null);
		busOperatorService.addBus(b);
	}
	
	@Test
	void getRevenueByBusRoute() {
		String routeName = "AtoB";
		busOperatorService.getRevenueByBusRoute(routeName);
	}
	
	@Test
	void getRevenueByBusRouteAndDate() {
		String routeName = "AtoB";
		LocalDate date = LocalDate.now();
		busOperatorService.getRevenueByBusRouteAndDate(routeName, date);
	}
	
	@Test
	void getMonthlyRevenueByBusRoute()
	{
		String routeName="A to B";
		String month="3";
		String year = "2021";
		busOperatorService.getMonthlyRevenueByBusRoute(routeName, month, year);
	}
	@Test
	void getYearlyRevenueByBusRoute()
	{
		String routeName="A to B";
		String year="2021";
		busOperatorService.getYearlyRevenueByBusRoute(routeName, year);
	}
	
	@Test
	void addBusOperator()
	{
		BusOperator busOp=new BusOperator("Sid","123",null,null,null);
		busOperatorService.addBusOperator(busOp);
	}
	
	@Test
	void updatePassword()
	{
		String oldPassword="dad";
		String newPassword="mom-dad";
		busOperatorService.updatePassword(oldPassword, newPassword);
	}
}
