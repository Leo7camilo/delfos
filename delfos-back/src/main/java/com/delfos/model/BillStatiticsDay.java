package com.delfos.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BillStatiticsDay {
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'")
	private LocalDate date;
	
	private BigDecimal cashValue;
	
	
	public BillStatiticsDay() {
	}

	public BillStatiticsDay(LocalDate date, BigDecimal cashValue) {
		this.date = date;
		this.cashValue = cashValue;
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
	
	

}
