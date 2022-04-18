package com.delfos.services;

import java.time.LocalDate;
import java.util.List;

import com.delfos.model.BillStatiticsDay;

public interface BillService {

	List<BillStatiticsDay> byDay(LocalDate monthReference);

}
