package com.delfos.dtos;

import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.delfos.enums.State;
import com.delfos.enums.UserType;
import com.delfos.model.Document;

public class UserDto {
	
	@NotNull
    @Size(min = 5, max = 50)
	private String name;

	@Email
	private String email;
	
	private Document document;

	@NotNull
    @Size(min = 8, max = 8)
	private String cep;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private State state;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private UserType type;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}


	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}

}

