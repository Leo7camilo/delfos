package com.delfos.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import com.delfos.enums.BillType;
import com.fasterxml.jackson.annotation.JsonFormat;

public class BillStatiticsDay {
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private LocalDate date;
	
	private BigDecimal cashValue;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private BillType type;
	
	
	public BillStatiticsDay() {
	}

	public BillStatiticsDay(BillType type, LocalDate date, BigDecimal cashValue) {
		this.date = date;
		this.cashValue = cashValue;
		this.setType(type);
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
	
	

}
