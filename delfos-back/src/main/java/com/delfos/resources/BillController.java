package com.delfos.resources;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delfos.exception.handler.DelfosExceptionHandler.Erro;
import com.delfos.model.Bill;
import com.delfos.model.BillStatiticsDay;
import com.delfos.model.User;
import com.delfos.services.BillService;
import com.delfos.services.UserService;
import com.delfos.services.exception.CepInvalidoException;
import com.delfos.services.exception.UserNotFoundException;
import com.delfos.services.impl.UserServiceImpl;

@RestController
@RequestMapping("/${api.version}/bill")
public class BillController {
	
	
	@Autowired
	BillService billService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping("users/{userId}")
	@PreAuthorize("hasAuthority('ROLE_SEARCH_BILL') and hasAuthority('SCOPE_write')")
	public ResponseEntity<Bill> findById(@PathVariable Long userId) {
		
		
		Optional<User> user = userService.findById(userId);
		if(!user.isPresent()) {
			throw new UserNotFoundException();
		}
		
		Bill bill = new Bill();
		
		
		bill.setDate(LocalDate.now(ZoneId.of("UTC")));
		bill.setCashValue(new BigDecimal("123.45"));
		bill.setKvwValue(104.2F);
		
		
		
		//Optional<User> categoria = billService.findById(userId);

		return ResponseEntity.ok(bill);
	}
	
	
	@GetMapping("/statistics/by-day")
	public List<BillStatiticsDay> byDay() {
		return billService.byDay(LocalDate.now());
	}
	
	@ExceptionHandler({ UserNotFoundException.class })
	public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex) {
		String mensagemUsuario = messageSource.getMessage("user.nao-encotrado", null, LocaleContextHolder.getLocale());
		String mensagemDesenvolvedor = ex.toString();
		List<Erro> erros = Arrays.asList(new Erro(mensagemUsuario, mensagemDesenvolvedor));
		return ResponseEntity.badRequest().body(erros);
	}
	
	

}
