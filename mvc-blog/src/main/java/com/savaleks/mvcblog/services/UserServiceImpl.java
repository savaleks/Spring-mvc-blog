package com.savaleks.mvcblog.services;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.savaleks.mvcblog.models.Role;
import com.savaleks.mvcblog.models.User;
import com.savaleks.mvcblog.repository.RoleRepository;
import com.savaleks.mvcblog.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(1);
		Role userRole = roleRepository.findByRole("ADMIN");
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		userRepository.save(user);
	}

	@Override
	public List<User> findAll() {
		
		return this.userRepository.findAll();
	}

	@Override
	public User findById(int id) {
		
		return userRepository.findById(id);
	}

	@Override
	public User create(User user) {
		
		return this.userRepository.save(user);
	}

	@Override
	public User edit(User user) {
		
		return this.userRepository.save(user);
	}

	@Override
	public void deleteById(Long id) {
		
		userRepository.deleteById(id);
		
	}

}
