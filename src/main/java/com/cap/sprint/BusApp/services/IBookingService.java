package com.cap.sprint.BusApp.services;

import java.time.LocalDate;
import java.util.List;

import com.cap.sprint.BusApp.entities.Booking;
import com.cap.sprint.BusApp.entities.Feedback;
import com.cap.sprint.BusApp.entities.User;

public interface IBookingService {
	
	public long addBooking(Booking booking);
	
	public boolean updateBookingDate(long bookingId);
	
	public boolean deleteBooking (long bookingid);
	
	public Booking getBookingDetailsById(long bookingid);
	
	public List<Booking> getAllBookingByDate(LocalDate date);
	
	public List<Booking> getAllBookingByBusRoute(String routeName);
	
	public List<Feedback> getFeedbackByBusRoute(String routeName);
	
	public List<Booking> findAllBooking();
	
	public void addFeedback(User user,long bookingId);
	
	public void addFeedback(String username, long bookingid, String comment);
}
