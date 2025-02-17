package com.cap.sprint.BusApp.serviceinterfaces;

import java.util.List;

import com.cap.sprint.BusApp.entities.User;

public interface IUserService {
	
	//Service methods to be implemented by Service Implementation Class
	
	public void addUser(User user);
	
	public void deleteUser(String username);
	
	public void updateUser(String username, String password);
	
	public List<User> getAllUsers();
	
}
