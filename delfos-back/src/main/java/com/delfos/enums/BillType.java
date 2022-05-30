package com.delfos.enums;

public enum BillType {

	DESPESA("Despesa"),
	KVW("kvw");
	
	private final String description;
	
	BillType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	
}
