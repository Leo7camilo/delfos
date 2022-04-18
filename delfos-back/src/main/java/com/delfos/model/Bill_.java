package com.delfos.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Bill.class)
public abstract class Bill_ {

	
	public static volatile SingularAttribute<Bill, Long> id;
	public static volatile SingularAttribute<Bill, LocalDate> date;
	public static volatile SingularAttribute<Bill, BigDecimal> cashValue;
	public static volatile SingularAttribute<Bill, Float> kvwValue;

	public static final String ID = "id";
	public static final String DATE = "date";
	public static final String CASHVALUE = "cashValue";
	public static final String KVWVALUE = "kvwValue";
	

}
