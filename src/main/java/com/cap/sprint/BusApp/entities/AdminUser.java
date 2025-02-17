package com.cap.sprint.BusApp.entities;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Entity Creation with annotation
@Entity
public class AdminUser {
	
	//Primary key field
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	//fields (or) columns
	String adminUsername;
	String password;
	ArrayList<Integer> caseNumber;
	
	//Non-parameterized constructor
	public AdminUser(){
		super();
	}

	//Parameterized constructor
	public AdminUser(String adminUsername, String password, ArrayList<Integer> caseNumber) {
		super();
		this.adminUsername = adminUsername;
		this.password = password;
		this.caseNumber = caseNumber;
	}

	//Getters and Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdminUsername() {
		return adminUsername;
	}
	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public ArrayList<Integer> getCaseNumber() {
		return caseNumber;
	}
	public void setCaseNumber(ArrayList<Integer> caseNumber) {
		this.caseNumber = caseNumber;
	}
	
}
