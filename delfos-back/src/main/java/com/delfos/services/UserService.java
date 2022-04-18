package com.delfos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.delfos.model.User;
import com.delfos.specification.SpecificationTemplate.UserSpec;

public interface UserService {
	
	User createUser(User user);

	Optional<User> findById(Long id);

	Page<User> findAll(UserSpec spec, Pageable pageable);

}