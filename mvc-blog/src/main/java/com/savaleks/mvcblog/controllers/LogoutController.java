package com.savaleks.mvcblog.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.savaleks.mvcblog.models.User;
import com.savaleks.mvcblog.services.UserService;

@Controller
public class LogoutController {
	
	@Autowired
	private UserService userService;
	
	  @PostMapping("/")
	  public String logout(HttpSession session, Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		model.addAttribute("username", user.getUsername());
	    session.invalidate();
	    return "redirect:/";
	  }

}
