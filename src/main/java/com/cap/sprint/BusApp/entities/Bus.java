package com.cap.sprint.BusApp.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

//Entity Creation with annotation
@Entity
public class Bus {
	
	//Primary key field
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@OnDelete(action = OnDeleteAction.CASCADE)
	int id;
	
	//fields (or) columns
	String busNumber;
	int totalSeats;
	int fare;
	
	//Unidirectional mapping to Bus table
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bus_operator")
	BusOperator busOperator;
	
	//bidirectional mapping to BusRoute table
	@ManyToOne
	@JoinColumn(name = "bus_route")
	BusRoute busRoute;

	//Non-parameterized constructor
	public Bus() {
		super();
	}

	//Parameterized constructor
	public Bus(String busNumber, int totalSeats, int fare, BusOperator busOperator) {
		super();
		this.busNumber = busNumber;
		this.totalSeats = totalSeats;
		this.fare = fare;
	}

	//Getters and Setters
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

}
