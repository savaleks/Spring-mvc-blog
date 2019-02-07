package com.savaleks.mvcblog.models;

import java.util.HashSet;
import java.util.Set;

public class User {

	private int id;
	private String username;
	private String password;
	private String fullName;
	private Set<Post> posts = new HashSet<>();
	
	public User() {}

	public User(int id, String username, String fullName) {
		this.id = id;
		this.username = username;
		this.fullName = fullName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Set<Post> getPosts() {
		return posts;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", fullName=" + fullName + "]";
	}
	
	
}
