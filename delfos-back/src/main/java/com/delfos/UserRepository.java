package com.delfos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.delfos.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
