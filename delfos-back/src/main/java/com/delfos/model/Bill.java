package com.delfos.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;

import com.delfos.enums.BillType;
import com.delfos.enums.UserType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;



@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "BILL")
public class Bill implements Serializable{

	
	private static final long serialVersionUID = 2509077143522228051L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'")
	private LocalDate date;
	
	private BigDecimal cashValue;
	
	private Float kvwValue;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private BillType type;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    //@ManyToMany(mappedBy = "bills")
	
	/*@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "bill_user", joinColumns = @JoinColumn(name = "bill_id")
		, inverseJoinColumns = @JoinColumn(name = "id_user"))*/
	
	@ManyToOne
    @JoinColumn(name = "user_id")
	private User user_id;

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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public User getUser_id() {
		return user_id;
	}

	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bill other = (Bill) obj;
		if (id != other.id)
			return false;
		return true;
	}	

}
