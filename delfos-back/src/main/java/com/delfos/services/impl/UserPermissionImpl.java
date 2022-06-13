package com.delfos.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delfos.model.UserPermission;
import com.delfos.repository.UserPermissionRepository;
import com.delfos.services.UserPermissionInterface;

@Service
public class UserPermissionImpl implements UserPermissionInterface{
	
	@Autowired
	UserPermissionRepository userPermissionRepository;

	@Override
	public void setPermissionToUser(long userId, int permissionId) {
		
		UserPermission userPermission = new UserPermission();
		userPermission.setIdUser(userId);
		userPermission.setIdPermission(permissionId);
		userPermissionRepository.save(userPermission);
		
	}

}
