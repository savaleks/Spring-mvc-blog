package com.savaleks.mvcblog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.savaleks.mvcblog.models.Post;
import com.savaleks.mvcblog.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public List<Post> findAll() {
		
		return postRepository.findAll();
	}

	@Override
	public List<Post> findLatest5() {
		
		return postRepository.findLatest5Posts(PageRequest.of(0, 5));
	}

	@Override
	public Post findById(int id) {
		
		return postRepository.findById(id).orElse(null);
	}

	@Override
	public Post create(Post post) {
		return postRepository.save(post);
	}

	@Override
	public Post edit(Post post) {
		return postRepository.save(post);
	}

	@Override
	public void deleteById(int id) {
		postRepository.deleteById(id);
	}

}
