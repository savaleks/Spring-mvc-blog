package com.savaleks.mvcblog.services;

import java.util.List;

import com.savaleks.mvcblog.models.User;

public interface UserService {

	public User findUserByEmail(String email);
	
	public void saveUser(User user);
	
	public List<User> findAll();
	
	public User findById(int id);
	
	public User create (User user);
	
	public User edit(User user);
	
	public void deleteById(Long id);
	
}
