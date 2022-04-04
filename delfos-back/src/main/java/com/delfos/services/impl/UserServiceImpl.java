package com.delfos.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delfos.UserRepository;
import com.delfos.model.User;
import com.delfos.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public User createUser(User user) {
		User userCreated = userRepository.save(user);
		return userCreated == null ? new User() : userCreated;
	}
	
	
	
	

}
