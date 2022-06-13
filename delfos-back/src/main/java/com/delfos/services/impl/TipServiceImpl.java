package com.delfos.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.delfos.model.Tip;
import com.delfos.model.User;
import com.delfos.repository.TipRepository;
import com.delfos.services.TipService;
import com.delfos.specification.SpecificationTemplate.TipSpec;

@Service
public class TipServiceImpl implements TipService{

	
	@Autowired
	TipRepository tipRepository;
	
	@Override
	public Page<Tip> findAll(TipSpec spec, Pageable pageable) {
		
		return tipRepository.findAll(spec, pageable);
	}

	@Override
	public Optional<Tip> findById(Long id) {

		Optional<Tip> tip = tipRepository.findById(id);
		return tip;
	}

	@Override
	public Tip createTip(Tip tip) {
		
		return tipRepository.save(tip);
	}
	
	

}
