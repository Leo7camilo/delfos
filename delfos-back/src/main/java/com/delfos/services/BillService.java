package com.delfos.services;

import java.time.LocalDate;
import java.util.List;

import com.delfos.model.BillStatiticsDay;
import com.delfos.model.BillStatiticsUser;

public interface BillService {

	List<BillStatiticsDay> byDay(LocalDate monthReference, Long userId);

	List<BillStatiticsUser> byUser(LocalDate monthReference, Long userId);

}
