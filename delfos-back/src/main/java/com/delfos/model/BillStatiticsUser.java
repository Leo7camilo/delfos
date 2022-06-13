package com.delfos.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import com.delfos.enums.BillType;
import com.fasterxml.jackson.annotation.JsonFormat;

public class BillStatiticsUser {
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private LocalDate date;
	
	private BigDecimal cashValue;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private BillType type;
	
	private Float kvwValue;
	
	public BillStatiticsUser() {
	}

	public BillStatiticsUser(BillType type, LocalDate date, Float kvwValue, BigDecimal cashValue) {
		this.date = date;
		this.cashValue = cashValue;
		this.setType(type);
		this.kvwValue = kvwValue;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public BigDecimal getCashValue() {
		return cashValue;
	}

	public void setCashValue(BigDecimal cashValue) {
		this.cashValue = cashValue;
	}

	public BillType getType() {
		return type;
	}

	public void setType(BillType type) {
		this.type = type;
	}

	public Float getKvwValue() {
		return kvwValue;
	}

	public void setKvwValue(Float kvwValue) {
		this.kvwValue = kvwValue;
	}

	@Override
	public String toString() {
		return "BillStatiticsUser [date=" + date + ", cashValue=" + cashValue + ", type=" + type + ", kvwValue="
				+ kvwValue + "]";
	}
	

}
