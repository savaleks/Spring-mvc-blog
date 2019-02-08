package com.savaleks.mvcblog.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.savaleks.mvcblog.models.Post;
import com.savaleks.mvcblog.models.User;

@Service
public class PostServiceImpl implements PostService {
	
	private List<Post> posts = new ArrayList<Post>() {{
		add(new Post(1,"First Post", "<p>Line #1.</p><p>Line #2</p>", null));
//		add(new Post(2,"Second Post", "Sercond post content:"
//				+ "<ul><li>line 1</li><li>Line 2</li></p>", 
//				new User(10, "ton22", "Petras Petraitis")));
//		add(new Post(3,"Third Post", "<p>Third post content:</p>"
//				+ "<ul><li>line 1</li><li>Line 2</li></p>", 
//				new User(10, "bollo", null)));
		add(new Post(4,"Forth Post", "<p>Not interesting post</p>", null));
		add(new Post(5,"Fifth Post", "<p>Just posting</p>", null));
		add(new Post(6,"Sixth Post", "<p>Another interesting post</p>", null));
	}};

	@Override
	public List<Post> findAll() {
		
		return this.posts;
	}

	@Override
	public List<Post> findLatest5() {
		
		return this.posts.stream()
				.sorted((a,b) -> b.getDate().compareTo(a.getDate()))
				.limit(5)
				.collect(Collectors.toList());
	}

	@Override
	public Post findById(int id) {
		
		return this.posts.stream()
				.filter(p -> Objects.equals(p.getId(), id))
				.findFirst()
				.orElse(null);
	}

	@Override
	public Post create(Post post) {
		post.setId(this.posts.stream().mapToInt(p -> p.getId()).max().getAsInt() + 1);
		this.posts.add(post);
		return post;
	}

	@Override
	public Post edit(Post post) {
		for (int i=0; i<this.posts.size(); i++) {
			if (Objects.equals(this.posts.get(i).getId(), post.getId())) {
				this.posts.set(i, post);
				return post;
			}
		}
		throw new RuntimeException("Post not found: " + post.getId());
	}

	@Override
	public void deleteById(int id) {
		for (int i=0; i<this.posts.size(); i++) {
			if (Objects.equals(this.posts.get(i).getId(), id)) {
				this.posts.remove(i);
				return;
			}
		}
		throw new RuntimeException("Post not found: " + id);
	}

}
