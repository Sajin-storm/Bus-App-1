package com.cap.sprint.BusApp.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.sprint.BusApp.entities.Booking;
import com.cap.sprint.BusApp.entities.Feedback;
import com.cap.sprint.BusApp.entities.User;
import com.cap.sprint.BusApp.exception.BookingAlreadyExistException;
import com.cap.sprint.BusApp.exception.BookingNotFoundException;
import com.cap.sprint.BusApp.exception.UserNotFoundException;
import com.cap.sprint.BusApp.repos.IBookingRepository;
import com.cap.sprint.BusApp.repos.IBusOperatorRepository;
import com.cap.sprint.BusApp.repos.IFeedbackRepository;
import com.cap.sprint.BusApp.repos.IUserRepository;

@Service

public class BookingServiceImpl implements IBookingService {
	
	@Autowired
	IBookingRepository bookingRepository;
	
	@Autowired
	IFeedbackRepository feedbackRepository;
	
	@Autowired
	IBusOperatorRepository busOperatorRepository;
	
	@Autowired
	IUserRepository userRepository;
	
	//addBooking(Booking):long
	@Override
	public long addBooking(Booking booking) {
		Booking b1 = bookingRepository.findByUsername(booking.getUsername());
		if(b1 == null) {
			bookingRepository.save(booking);
		} 
		else {
			throw new BookingAlreadyExistException("User already exist");
		}
		return booking.getBookingId();
	}

	
	@Override
	public boolean updateBookingDate(long bookingId) {
		boolean result = false;
		Optional<Booking> b = bookingRepository.findByBookingId(bookingId);
		Booking b1 = null;
		if(b.isPresent()) {
			b1 = b.get();
			b1.setDate(LocalDate.now());
			result = true;
		}
		return result;
	}
	
	//deleteBooking(long):boolean
	@Override
	public boolean deleteBooking (long bookingid) {
		Optional<Booking> booking = bookingRepository.findByBookingId(bookingid);
		Booking b = null;
		boolean result = false;
		if (booking.isPresent()) {
			b=booking.get();
			b.setBus(null);
			b.setBusRoute(null);
			bookingRepository.delete(b);
			result = true;
		} else {
			throw new BookingNotFoundException("booking doesn't exist!!!");
		}
		return result;
	}
	
	//getBookingDetailsById(long):Booking
	@Override
	public Booking getBookingDetailsById(long bookingid) {
		Booking b = null;
		Optional<Booking> booking = bookingRepository.findByBookingId(bookingid);
		if (booking.isPresent()) {
			b= booking.get();
		}
		return b;
	}
	
	//getAllBookingByDate(LocalDate):List<Booking>
	@Override
	public List<Booking> getAllBookingByDate(LocalDate date){
		List<Booking> booking = bookingRepository.findByDate(date);
		return booking;
	}

	//getAllBookingByBusRoute(String):List<Booking>
	@Override
	public List<Booking> getAllBookingByBusRoute(String routeName){
		List<Booking> booking = bookingRepository.findByBusRouteRouteName(routeName);
		return booking;
	}
	
	//getFeedbackByBusRoute(String):List<Booking>
	@Override
	public List<Feedback> getFeedbackByBusRoute(String routeName){
		List<Feedback> feedback = feedbackRepository.findByRouteName(routeName);
		return feedback;
	}
	
	//own method to find all booking
	@Override
	public List<Booking> findAllBookings(){
		List<Booking> booking = bookingRepository.findAll();
		if (booking.isEmpty()) {
			throw new BookingNotFoundException("bookings does not exist!!!");
		}
		return booking;
	}
	
	//addFeedback(User,Long):void
	@Override
	public void addFeedback(User user,long bookingId) {
		
		Optional<Booking> booking = bookingRepository.findByBookingId(bookingId);
		Booking b = null;
		Feedback f = new Feedback();
		if(booking.isPresent()) {
			b = booking.get();
		} 
		else {
			throw new BookingNotFoundException("Booking not found");
		}
		
		Optional<User> user1 = userRepository.findByUsername(user.getUsername());
		User u = null;
		if(user1.isPresent()) {
			u = user1.get();
		} else {
			throw new UserNotFoundException("User not found!!!");
		}
		
		
		f.setRouteName((b.getBusRoute()).getRouteName());
		f.setUsername(u.getUsername());
		f.setUser(u);
		feedbackRepository.save(f);
 	}
	
	//addFeedback(String,long,String):void
	@Override
	public void addFeedback(String username, long bookingid, String comment) {
		Optional<Booking> booking = bookingRepository.findByBookingId(bookingid);
		Feedback feedback = feedbackRepository.findByUsername(username);
		Feedback f = null;
		Feedback f1 = new Feedback();
		Booking b = null;
		if(booking.isPresent()) {
			b = booking.get();
		}

		Optional<User> user = userRepository.findByUsername(username);
		User u = null;
		if(user.isPresent()) {
			u = user.get();
		}
	
		if(booking.isPresent() && feedback != null) {
			f = feedback;
			f.setComment(comment);
			feedbackRepository.save(f);
		}
		else {
			f1.setRouteName((b.getBusRoute()).getRouteName());
			f1.setComment(comment);
			f1.setUsername(username);
			f1.setUser(u);
			feedbackRepository.save(f1);
		}
	}
}
