package com.food.dao;

import java.util.List;

import com.food.model.User;

public interface UserDAO {
	
	void addUser(User user);
	
	void addAddressByUser(User user);
	
	User getUser(int userId);
	
	void updateUser(User user);
	
	void deleteUser(int userId);
	
	List<User> getAllUser();
	
	User getUserByName(String name);
}
