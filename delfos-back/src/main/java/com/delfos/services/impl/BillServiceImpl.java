package com.delfos.services.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.delfos.enums.BillType;
import com.delfos.model.Bill;
import com.delfos.model.BillStatiticsDay;
import com.delfos.model.BillStatiticsUser;
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
	
	Float totalKvw = 0F;
	BigDecimal totalCashConta = BigDecimal.ZERO;
	BigDecimal totalCashKwv = BigDecimal.ZERO;

	@Override
	public List<BillStatiticsDay> byDay(LocalDate monthReference, Long userId) {
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();

		CriteriaQuery<BillStatiticsDay> criteriaQuery = criteriaBuilder
				.createQuery(BillStatiticsDay.class);

		Root<Bill> root = criteriaQuery.from(Bill.class);
		
		criteriaQuery.select(criteriaBuilder.construct(BillStatiticsDay.class,
				root.get(Bill_.type),
				root.get(Bill_.date),
				criteriaBuilder.sum(root.get(Bill_.cashValue))));
		

		LocalDate primeiroDia = monthReference.withDayOfMonth(1);
		LocalDate ultimoDia = monthReference.withDayOfMonth(monthReference.lengthOfMonth());

		criteriaQuery.where(
				criteriaBuilder.greaterThanOrEqualTo(root.get(Bill_.date),
					primeiroDia),
				criteriaBuilder.lessThanOrEqualTo(root.get(Bill_.date), 
					ultimoDia),
				criteriaBuilder.equal(root.get(Bill_.user_id), userId));;

		criteriaQuery.groupBy(root.get(Bill_.type),root.get(Bill_.date));

		TypedQuery<BillStatiticsDay> typedQuery = manager.createQuery(criteriaQuery);

		return typedQuery.getResultList();
	}

	@Override
	public List<BillStatiticsUser> byUser(LocalDate monthReference, Long userId) {
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();

		CriteriaQuery<BillStatiticsUser> criteriaQuery = criteriaBuilder
				.createQuery(BillStatiticsUser.class);

		Root<Bill> root = criteriaQuery.from(Bill.class);
		
		criteriaQuery.select(criteriaBuilder.construct(BillStatiticsUser.class,
				root.get(Bill_.type),
				root.get(Bill_.date),
				root.get(Bill_.kvwValue),
				root.get(Bill_.cashValue)));
				//criteriaBuilder.sum(root.get(Bill_.kvwValue)),
				//criteriaBuilder.sum(root.get(Bill_.cashValue))));
		

		LocalDate primeiroDia = monthReference.withDayOfMonth(1);
		LocalDate ultimoDia = monthReference.withDayOfMonth(monthReference.lengthOfMonth());

		criteriaQuery.where(
				criteriaBuilder.greaterThanOrEqualTo(root.get(Bill_.date),
					primeiroDia),
				criteriaBuilder.lessThanOrEqualTo(root.get(Bill_.date), 
					ultimoDia),
				criteriaBuilder.equal(root.get(Bill_.user_id), userId));

		criteriaQuery.groupBy(root.get(Bill_.type),root.get(Bill_.date));

		TypedQuery<BillStatiticsUser> typedQuery = manager.createQuery(criteriaQuery);
		
		var billUserTotalConta = new BillStatiticsUser();
		var billUserTotalKvw = new BillStatiticsUser();
		
		typedQuery.getResultList().forEach(billUser -> {
			
			if(billUser.getType().equals(BillType.DESPESA)) {
				System.out.println(billUser);
				totalCashConta = totalCashConta.add(billUser.getCashValue());
				totalKvw += billUser.getKvwValue();
			}
			else if(billUser.getType().equals(BillType.KVW)) {
				System.out.println(billUser);
				totalCashKwv = totalCashKwv.add(billUser.getCashValue());
				totalKvw += billUser.getKvwValue();
			}
			
			
			
		});
		billUserTotalConta.setType(BillType.DESPESA);
		billUserTotalConta.setDate(LocalDate.now());
		billUserTotalConta.setCashValue(totalCashConta);
		billUserTotalConta.setKvwValue(totalKvw);
		
		billUserTotalKvw.setType(BillType.KVW);
		billUserTotalKvw.setDate(LocalDate.now());
		billUserTotalKvw.setCashValue(totalCashKwv);
		billUserTotalKvw.setKvwValue(totalKvw);
		
		totalKvw = 0F;
		totalCashConta = BigDecimal.ZERO;
		totalCashKwv = BigDecimal.ZERO;

		List<BillStatiticsUser> list = new ArrayList<>();
		list.add(billUserTotalConta);
		list.add(billUserTotalKvw);
		return list;

	}

}
