package com.delfos.enums;

public enum BillType {

	DESPESA("Despesa");
	
	private final String description;
	
	BillType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	
}
