package com.cap.sprint.BusApp.services;

import java.util.List;

import com.cap.sprint.BusApp.entities.BusOperator;
import com.cap.sprint.BusApp.entities.Feedback;

public interface IFeedbackService {

	public Feedback addFeedback(Feedback feedback);
	
	public List<Feedback> viewAllFeedbacks(String routeName , BusOperator busOperator);
	
	public List<Feedback> viewAllFeedbacks(BusOperator busOperator);
	
	public List<Feedback> getAllFeedbacks();
	
}
