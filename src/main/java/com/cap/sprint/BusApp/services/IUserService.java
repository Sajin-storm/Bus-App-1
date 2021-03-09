package com.cap.sprint.BusApp.services;

import java.util.List;

import com.cap.sprint.BusApp.entities.User;

public interface IUserService {
	
	public void addUser(User user);
	
	public void deleteUser(String username);
	
	public void updateUser(String username, String password);
	
	public List<User> getAllUsers();
	
}
