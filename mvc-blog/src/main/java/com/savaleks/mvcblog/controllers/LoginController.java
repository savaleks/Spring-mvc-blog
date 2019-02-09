package com.savaleks.mvcblog.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.savaleks.mvcblog.models.Post;
import com.savaleks.mvcblog.models.User;
import com.savaleks.mvcblog.services.PostService;
import com.savaleks.mvcblog.services.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PostService postService;
	
	@GetMapping("/")
	public ModelAndView login(Model theModel) {
		
		List<Post> latesFifthPost = postService.findLatest5();
		theModel.addAttribute("latestFifth", latesFifthPost);
		
		List<Post> latestThreePost = latesFifthPost.stream()
													.limit(3)
													.collect(Collectors.toList());
		theModel.addAttribute("latestThree", latestThreePost);
		
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		return model;
	}
	
	@GetMapping("/home")
	public ModelAndView home() {
		ModelAndView model = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		model.addObject("username", user.getUsername());
		model.setViewName("/home");
		return model;
	}
	
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView model = new ModelAndView();
		User user = new User();
		model.addObject("user", user);
		model.addObject("username", "Hello, " + user.getUsername());
		model.setViewName("users/login");
		
		return model;
	}
	
	@GetMapping("/signup")
	public ModelAndView signup() {
		ModelAndView model = new ModelAndView();
		User user = new User();
		model.addObject("user", user);
		model.setViewName("users/signup");
		
		return model;
	}
	
	@PostMapping("/signup")
	public ModelAndView createUser(@Valid User user, BindingResult result) {
		ModelAndView model = new ModelAndView();
		User userExist = userService.findUserByEmail(user.getEmail());
		if(userExist != null) {
			result.rejectValue("email", "error.user", "This email already exists");
		}
		if(result.hasErrors()) {
			model.setViewName("users/signup");
		} else {
			userService.saveUser(user);
			model.addObject("msg", "User has been registered successfully.");
			model.addObject("user", new User());
			model.setViewName("users/login");
		}
		return model;
	}
	
	
	@GetMapping("/access_denied")
	public ModelAndView accessDenied() {
		ModelAndView model = new ModelAndView();
		model.setViewName("errors/access_denied");
		return model;
	}
	
	
	@GetMapping("/users")
	public ModelAndView usersPost() {
		ModelAndView model = new ModelAndView();
		model.setViewName("posts/users");
		return model;
	}
}
