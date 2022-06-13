package com.delfos.enums;

public enum BillType {

	ENERGIA("Energia"),
	KWH("kwh");
	
	private final String description;
	
	BillType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	
}
