package com.savaleks.mvcblog.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginForm {
	
	@Size(min=1, max=20, message="Username size should be in the range 1-20")
	private String username;
	@NotNull
	@Size(min=5, max=50)
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
