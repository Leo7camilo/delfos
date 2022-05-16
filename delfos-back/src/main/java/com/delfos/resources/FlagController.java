package com.delfos.resources;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delfos.exception.handler.DelfosExceptionHandler.Erro;
import com.delfos.model.BillStatiticsDay;
import com.delfos.model.Flag;
import com.delfos.model.User;
import com.delfos.services.CepService;
import com.delfos.services.FlagService;
import com.delfos.services.exception.FlagNotFoundException;
import com.delfos.services.exception.UserNotFoundException;

@RestController
@RequestMapping("/${api.version}/flag")
public class FlagController {
	
	

	@Autowired
	FlagService flagService;
	
	@Autowired
	private MessageSource messageSource;
	
	
	@GetMapping()
	public ResponseEntity<Flag> findAllFlags() {
		
		List<Flag> flags = flagService.findAll();
		
		Random rand = new Random();
		
		return new ResponseEntity<Flag>(flags.get(rand.nextInt(flags.size())), HttpStatus.OK);	
	}
	
	
	
	@ExceptionHandler({ UserNotFoundException.class })
	public ResponseEntity<Object> handleFlagNotFoundException(FlagNotFoundException ex) {
		String mensagemUsuario = messageSource.getMessage("flag.nao-encotrado", null, LocaleContextHolder.getLocale());
		String mensagemDesenvolvedor = ex.toString();
		List<Erro> erros = Arrays.asList(new Erro(mensagemUsuario, mensagemDesenvolvedor));
		return ResponseEntity.badRequest().body(erros);
	}
	
	

}
