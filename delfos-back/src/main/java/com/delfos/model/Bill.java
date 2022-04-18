package com.delfos.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;



@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "USER")
public class Bill implements Serializable{

	
	private static final long serialVersionUID = 2509077143522228051L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'")
	private LocalDate date;
	
	private BigDecimal cashValue;
	
	private Float kvwValue;

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

	public Float getKvwValue() {
		return kvwValue;
	}

	public void setKvwValue(Float kvwValue) {
		this.kvwValue = kvwValue;
	}
	

}
