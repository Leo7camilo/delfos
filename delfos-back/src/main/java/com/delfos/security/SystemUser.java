package com.delfos.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class SystemUser extends User {
	
    private static final long serialVersionUID = 1L;

	private com.delfos.model.User usuario;

	public SystemUser(com.delfos.model.User usuario, Collection<? extends GrantedAuthority> authorities) {
		super(usuario.getName(), usuario.getPassword(), authorities);
		this.usuario = usuario;
	}

	public com.delfos.model.User getUsuario() {
		return usuario;
	}


}
