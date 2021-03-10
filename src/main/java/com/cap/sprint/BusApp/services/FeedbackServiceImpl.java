package com.cap.sprint.BusApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.sprint.BusApp.entities.BusOperator;
import com.cap.sprint.BusApp.entities.Feedback;
import com.cap.sprint.BusApp.entities.User;
import com.cap.sprint.BusApp.exception.UserNotFoundException;
import com.cap.sprint.BusApp.repos.IBusOperatorRepository;
import com.cap.sprint.BusApp.repos.IFeedbackRepository;
import com.cap.sprint.BusApp.repos.IUserRepository;
import com.cap.sprint.BusApp.serviceinterfaces.IFeedbackService;

@Service

public class FeedbackServiceImpl implements IFeedbackService {
	
	//Dependency injections of required repositories
	
	@Autowired
	IFeedbackRepository feedbackRepository;
	
	@Autowired
	IUserRepository userRepository;
	
	@Autowired
	IBusOperatorRepository busOperatorRepository;
	
	//Method to add a feedback
	@Override
	public Feedback addFeedback(Feedback feedback) {
		Feedback f = null;
		Optional<User> user = userRepository.findByUsername(feedback.getUsername());
		if(user.isPresent()) {
			feedback.setUser(user.get());
			f = feedbackRepository.save(feedback);
		} else {
			throw new UserNotFoundException("User not found!!!");
		}
		return f;
	}
	
	//Method to view all feedbacks of a certain bus operator from specific bus route
	@Override
	public List<Feedback> viewAllFeedbacks(String routeName , BusOperator busOperator){

		List<Feedback> f1 = feedbackRepository.findByRouteNameAndBusOperatorBusOperatorUsername(routeName, busOperator.getBusOperatorUsername());
		return f1;
	}
	
	//Method to view all feedbacks of a certain bus operator
	@Override
	public List<Feedback> viewAllFeedbacks(BusOperator busOperator){
		List<Feedback> feedback = feedbackRepository.findByBusOperatorBusOperatorUsername(busOperator.getBusOperatorUsername());
		return feedback;
	}
	
	@Override
	public List<Feedback> getAllFeedbacks(){
		List<Feedback> feedback = feedbackRepository.findAll();
		return feedback;
	}

}
