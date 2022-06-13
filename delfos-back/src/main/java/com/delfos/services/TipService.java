package com.delfos.services;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.delfos.model.Tip;
import com.delfos.model.User;
import com.delfos.specification.SpecificationTemplate.TipSpec;


public interface TipService {

	Page<Tip> findAll(TipSpec spec, Pageable pageable);

	Optional<Tip> findById(Long id);

	Tip createTip(Tip tip);

}
