package com.savaleks.mvcblog.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.savaleks.mvcblog.forms.LoginForm;
import com.savaleks.mvcblog.services.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/users/login")
	public String login(LoginForm loginForm) {
		return "users/login";
	}
	
	@PostMapping("/users/login")
	public String loginPage(@Valid LoginForm loginForm, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "users/login";
		}
		if(!userService.authenticate(loginForm.getUsername(), loginForm.getPassword())) {
			return "users/login";
		}
		return "redirect:/";
	}
}
