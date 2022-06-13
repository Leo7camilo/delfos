package com.delfos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.delfos.model.UserPermission;

public interface UserPermissionRepository extends JpaRepository<UserPermission, Long>{
	
	

}
