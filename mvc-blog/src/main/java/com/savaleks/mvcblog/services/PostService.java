package com.savaleks.mvcblog.services;

import java.util.List;

import com.savaleks.mvcblog.models.Post;

public interface PostService {
	
	List<Post> findAll();
	List<Post> findLatest5();
	Post findById(int id);
	Post create(Post post);
	Post edit(Post post);
	void deleteById(int id);

}
