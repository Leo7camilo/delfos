package com.delfos.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.delfos.enums.State;
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
		System.out.println();
		
		Page<User> findPrint = userRepository.findAll(spec, pageable);
		System.out.println(findPrint.getContent().toString());
		
		
		findPrint.getContent().forEach(x -> {
			System.out.println(x);
		});
		return findPrint;
	}

	@Override
	public Optional<User> findByEmail(String email) {
		Optional<User> user = userRepository.findByEmail(email);
		return user;
	}

	@Override
	public Optional<User> findByName(String name) {
		Optional<User> user = userRepository.findByName(name);
		return user;
	}

	@Override
	public void updatePropertyActive(Long id, Boolean ativo) {
		Optional<User> user = findById(id);
		if (user.isPresent()) {
			if(ativo) {
				System.out.println("Ativando usuario");
				user.get().setState(State.ATIVO);
			}else {
				System.out.println("Desativando usuario");
				user.get().setState(State.DESATIVO);
			}
			
			userRepository.save(user.get());
			
		}
		
	}
	
	
	
	

}
