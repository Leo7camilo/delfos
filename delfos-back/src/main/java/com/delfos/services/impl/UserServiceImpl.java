package com.delfos.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.delfos.model.User;
import com.delfos.repository.UserRepository;

import java.util.List;
import java.util.Optional;

import com.delfos.services.CepService;
import com.delfos.services.UserService;
import com.delfos.specification.SpecificationTemplate.UserSpec;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	

	@Override
	public User createUser(User user) {
		User userCreated = userRepository.save(user);
		return userCreated == null ? new User() : userCreated;
	}
	
	@Override
	public Optional<User> findById(Long id) {
		Optional<User> user = userRepository.findById(id);
		return user;
	}

	@Override
	public Page<User> findAll(UserSpec spec, Pageable pageable) {
		
		return userRepository.findAll(spec, pageable);
	}
	
	
	
	

}
