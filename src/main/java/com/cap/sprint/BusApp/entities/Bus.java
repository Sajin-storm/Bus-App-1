package com.cap.sprint.BusApp.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Bus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@OnDelete(action = OnDeleteAction.CASCADE)
	int id;
	String busNumber;
	int totalSeats;
	int fare;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bus_operator")
	BusOperator busOperator;
	
//	@OneToOne
//	BusOperatorRequest busOperatorRequest;
	
	@ManyToOne
	@JoinColumn(name = "busRoute")
	BusRoute busRoute;

	public Bus() {
		super();
	}

	public Bus(String busNumber, int totalSeats, int fare, BusOperator busOperator) {
		super();
		this.busNumber = busNumber;
		this.totalSeats = totalSeats;
		this.fare = fare;
//		this.busOperator = busOperator;
		//this.busOperatorRequest = busOperatorRequest;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}

	public BusRoute getBusRoute() {
		return busRoute;
	}

	public void setBusRoute(BusRoute busRoute) {
		this.busRoute = busRoute;
	}
	
//
//	public BusOperator getBusOperator() {
//		return busOperator;
//	}
//
//	public void setBusOperator(BusOperator busOperator) {
//		this.busOperator = busOperator;
//	}

//	public BusOperatorRequest getBusOperatorRequest() {
//		return busOperatorRequest;
//	}
//
//	public void setBusOperatorRequest(BusOperatorRequest busOperatorRequest) {
//		this.busOperatorRequest = busOperatorRequest;
//	}

}
