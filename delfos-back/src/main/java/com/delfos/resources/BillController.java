package com.delfos.resources;


import java.time.LocalDate;
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
import com.delfos.model.BillStatiticsDay;
import com.delfos.model.BillStatiticsUser;
import com.delfos.model.User;
import com.delfos.services.BillService;
import com.delfos.services.UserService;
import com.delfos.services.exception.UserNotFoundException;

@RestController
@RequestMapping("/${api.version}/bill")
public class BillController {
	
	
	@Autowired
	BillService billService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping("/statistics/by-user/{userName}")
	@PreAuthorize("hasAuthority('ROLE_SEARCH_BILL') and hasAuthority('SCOPE_write')")
	public List<BillStatiticsUser> findById(@PathVariable String userName) {
		
		Optional<User> user = userService.findByName(userName);
		if(!user.isPresent()) {
			throw new UserNotFoundException();
		}
		return billService.byUser(LocalDate.now(), user.get().getId());
	}
	

	@PreAuthorize("hasAuthority('ROLE_SEARCH_BILL') and hasAuthority('SCOPE_write')")
	@GetMapping("/statistics/by-day/{userName}")
	public List<BillStatiticsDay> byDay(@PathVariable String userName) {
		
		Optional<User> user = userService.findByName(userName);
		if(!user.isPresent()) {
			throw new UserNotFoundException();
		}
		
		
		return billService.byDay(LocalDate.now(), user.get().getId());
	}
	
	@ExceptionHandler({ UserNotFoundException.class })
	public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex) {
		String mensagemUsuario = messageSource.getMessage("user.nao-encotrado", null, LocaleContextHolder.getLocale());
		String mensagemDesenvolvedor = ex.toString();
		List<Erro> erros = Arrays.asList(new Erro(mensagemUsuario, mensagemDesenvolvedor));
		return ResponseEntity.badRequest().body(erros);
	}
	
	

}
