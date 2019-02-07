package com.savaleks.mvcblog.services;

public interface UserService {

	boolean authenticate(String username, String password);
}
