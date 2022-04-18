package com.delfos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.delfos.model.Tip;

public interface TipRepository extends JpaRepository<Tip, Long>, JpaSpecificationExecutor<Tip>{
	

}
