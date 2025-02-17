package com.cap.sprint.BusApp.test;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cap.sprint.BusApp.entities.Booking;
import com.cap.sprint.BusApp.entities.Bus;
import com.cap.sprint.BusApp.repos.IBookingRepository;
import com.cap.sprint.BusApp.repos.IBusRepository;
import com.cap.sprint.BusApp.services.AdminServiceImpl;

@SpringBootTest
class TestAdminServiceImpl {
	
	@Autowired
	AdminServiceImpl adminServiceImpl;
	
	@Autowired
	IBookingRepository bookingRepository;
	
	@Autowired
	IBusRepository busRepository;
	
//	@Test
	void testGetAllBusOperator() {
		System.out.println(adminServiceImpl.getAllBusOperator());
	}

//	@Test
	void testGetAllBusOperatorByRoute() {
		System.out.println(adminServiceImpl.getAllBusOperatorByRoute("A to B"));
	}

//	@Test
	void testGetAllBusOperatorsRequest() {
		System.out.println(adminServiceImpl.getAllBusOperatorsRequest());
	}

//	@Test
	@Transactional
	void testUpdateBusTime() {
		Bus bus = new Bus("ABC123",2,200,null);
		LocalTime startTime = LocalTime.parse("08:00");
		LocalTime endTime = LocalTime.parse("13:00");
		adminServiceImpl.updateBusTime(bus, startTime, endTime);
		
		Booking b = bookingRepository.findByBusBusNumber(bus.getBusNumber());
		System.out.println(bus);
		System.out.println(b);
		System.out.println(b.getJourneyStartTime());
	}

//	@Test
	@Transactional
	void testUpdateBusRoute() {
		Bus bus = new Bus("ABC123",2,200,null);

		String busRoute = "aaa";
		adminServiceImpl.updateBusRoute(bus, busRoute);
		Booking b = bookingRepository.findByBusBusNumber(bus.getBusNumber());
		System.out.println(bus);
		System.out.println(b);
		System.out.println(b.getBusRoute());
	}

//	@Test
	@Transactional
	void testUpdateBusFare() {
		Bus bus = new Bus("ABC123",2,200,null);
		adminServiceImpl.updateBusFare(bus, 500);
		Bus b2 = busRepository.findByBusNumber(bus.getBusNumber());
		System.out.println(bus);
		System.out.println(b2);
		System.out.println(b2.getFare());
	}

// 	@Test
	void testDeleteBus() {
		Bus bus = new Bus("ABC123",2,200,null);
		adminServiceImpl.deleteBus(bus);
	}

//	@Test
	void testDeleteBusByOperator() {
		adminServiceImpl.deleteBusByOperator("Ravi");
	}

//	@Test
	void testGetRevenueByDate() {
		LocalDate date = LocalDate.parse("2021-03-02");
		adminServiceImpl.getRevenueByDate(date);
	}

//	@Test
	void testGetRevenueByBusRoute() {
		adminServiceImpl.getRevenueByBusRoute("A to B");
	}

//	@Test
	@Transactional //to make the session open (to not lazily fetch)
	void testGetRevenueByBusOperator() {
		adminServiceImpl.getRevenueByBusOperator("Ravi");
	}

}
