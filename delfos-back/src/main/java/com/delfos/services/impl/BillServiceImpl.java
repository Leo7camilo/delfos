package com.delfos.services.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.delfos.model.Bill;
import com.delfos.model.BillStatiticsDay;
import com.delfos.model.Bill_;
import com.delfos.services.BillService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
public class BillServiceImpl implements BillService {
	
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<BillStatiticsDay> byDay(LocalDate monthReference) {
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();

		CriteriaQuery<BillStatiticsDay> criteriaQuery = criteriaBuilder
				.createQuery(BillStatiticsDay.class);

		Root<Bill> root = criteriaQuery.from(Bill.class);
		
		criteriaQuery.select(criteriaBuilder.construct(BillStatiticsDay.class, 
				root.get(Bill_.date),
				criteriaBuilder.sum(root.get(Bill_.cashValue))));
		

		LocalDate primeiroDia = monthReference.withDayOfMonth(1);
		LocalDate ultimoDia = monthReference.withDayOfMonth(monthReference.lengthOfMonth());

		criteriaQuery.where(criteriaBuilder.greaterThanOrEqualTo(root.get(Bill_.date), primeiroDia),
				criteriaBuilder.lessThanOrEqualTo(root.get(Bill_.date), ultimoDia));

		criteriaQuery.groupBy(root.get(Bill_.date));

		TypedQuery<BillStatiticsDay> typedQuery = manager.createQuery(criteriaQuery);

		return typedQuery.getResultList();
	}

}
