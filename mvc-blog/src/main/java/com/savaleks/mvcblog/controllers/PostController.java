package com.savaleks.mvcblog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.savaleks.mvcblog.models.Post;
import com.savaleks.mvcblog.services.PostService;

@Controller
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@RequestMapping("/posts/view/{id}")
	public String view(@PathVariable("id") int id, Model model) {
		
		Post post = postService.findById(id);
		model.addAttribute("post", post);
		return "posts/view";
	}
	
	@GetMapping("/create_post")
	public ModelAndView createPost() {
		ModelAndView model = new ModelAndView();
		model.setViewName("posts/create_post");
		return model;
	}

}
