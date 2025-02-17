package com.cap.sprint.BusApp.serviceinterfaces;

import java.util.List;

import com.cap.sprint.BusApp.entities.BusOperator;
import com.cap.sprint.BusApp.entities.Feedback;

public interface IFeedbackService {

	//Service methods to be implemented by Service Implementation Class
	
	public Feedback addFeedback(Feedback feedback);
	
	public List<Feedback> viewAllFeedbacks(String routeName , BusOperator busOperator);
	
	public List<Feedback> viewAllFeedbacks(BusOperator busOperator);
	

	public List<Feedback> getAllFeedbacks();
	

}
