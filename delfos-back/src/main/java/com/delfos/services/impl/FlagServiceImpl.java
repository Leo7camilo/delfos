package com.delfos.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delfos.model.Flag;
import com.delfos.repository.FlagRepository;
import com.delfos.services.FlagService;


@Service
public class FlagServiceImpl implements FlagService{

	
	@Autowired
	FlagRepository flagRepository;
	
	@Override
	public List<Flag> findAll() {
		return flagRepository.findAll();
	}
	
	
	

}
