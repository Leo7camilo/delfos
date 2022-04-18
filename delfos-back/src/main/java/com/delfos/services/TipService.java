package com.delfos.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.delfos.model.Tip;
import com.delfos.specification.SpecificationTemplate.TipSpec;


public interface TipService {

	Page<Tip> findAll(TipSpec spec, Pageable pageable);

}
