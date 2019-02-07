package com.savaleks.mvcblog.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.savaleks.mvcblog.models.Post;
import com.savaleks.mvcblog.services.PostService;

@Controller
public class HomeController {
	
	@Autowired
	private PostService postService;
	
	@RequestMapping("/")
	public String index(Model model) {
		
		List<Post> latesFifthPost = postService.findLatest5();
		model.addAttribute("latestFifth", latesFifthPost);
		
		List<Post> latestThreePost = latesFifthPost.stream()
													.limit(3)
													.collect(Collectors.toList());
		model.addAttribute("latestThree", latestThreePost);
		
		return "index";
	}
}
