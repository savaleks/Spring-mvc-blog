package com.savaleks.mvcblog.services;

import java.util.Objects;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public boolean authenticate(String username, String password) {
		// provide a sample password check: username == password
		return Objects.equals(username, password);
	}

}
