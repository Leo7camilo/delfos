package com.delfos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.delfos.model.User;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User>{

}