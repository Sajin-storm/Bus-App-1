package com.cap.sprint.BusApp.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cap.sprint.BusApp.entities.BusOperator;
import com.cap.sprint.BusApp.entities.Feedback;

import com.cap.sprint.BusApp.serviceinterfaces.IFeedbackService;



@SpringBootTest
class TestFeedbackService {
	
	@Autowired

	IFeedbackService feedbackService;

	
	@Test
	void testAddFeedback() {
		Feedback feedback = new Feedback();
		feedback.setRouteName("A to B");
		feedback.setUsername("Arijith");
		feedback.setRating(5);
		feedbackService.addFeedback(feedback);
	}

	@Test
	void testViewAllFeedbacksStringBusOperator() {
		BusOperator busOperator = new BusOperator();
		busOperator.setBusOperatorUsername("Ravi");
		busOperator.setPassword("Ravi123");
		feedbackService.viewAllFeedbacks("A to B", busOperator);
	}

	@Test
	void testViewAllFeedbacksBusOperator() {
		BusOperator busOperator = new BusOperator();
		busOperator.setBusOperatorUsername("Ravi");
		busOperator.setPassword("Ravi123");
		feedbackService.viewAllFeedbacks(busOperator);
	}

	@Test
	void testGetAllFeedbacks() {
		feedbackService.getAllFeedbacks();
	}

}
