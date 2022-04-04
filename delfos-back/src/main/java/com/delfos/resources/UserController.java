package com.delfos.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.delfos.model.User;
import com.delfos.services.UserService;
import com.delfos.services.impl.UserServiceImpl;

@RestController
public class UserController {
	
	@Autowired
	UserServiceImpl userCreatedImpl;
	
	public ResponseEntity<User> createUser(@Valid @RequestBody User user){
		
		User userCreated = userCreatedImpl.createUser(user);
		
		return new ResponseEntity<User>(userCreated, HttpStatus.CREATED);
		
	}

}
