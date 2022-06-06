package com.delfos.resources;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.delfos.model.User;
import com.delfos.services.CepService;
import com.delfos.services.UserPermissionInterface;
import com.delfos.services.UserService;
import com.delfos.services.exception.CepInvalidoException;
import com.delfos.services.exception.UserNotFoundException;
import com.delfos.specification.SpecificationTemplate;


import com.delfos.dtos.UserDto;
import com.delfos.exception.handler.DelfosExceptionHandler.Erro;

@RestController
@RequestMapping("/${api.version}/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	CepService cepService;
	
	@Autowired
	UserPermissionInterface userPermission;
	
	@Autowired
	private MessageSource messageSource;

	@PostMapping
	public ResponseEntity<User> createUser(@Valid @RequestBody UserDto userDto) {

		if (!cepService.findCep(userDto.getCep())) {
			throw new CepInvalidoException();
		}
		
		User user = new User();
		BeanUtils.copyProperties(userDto, user);
		user.setCreationDate(LocalDate.now());
		user.setUpdatedDate(LocalDate.now());
		user.setPassword(BCryptPasswordEncoder(user.getPassword()));
		User userCreated = userService.createUser(user);
		
		userPermission.setPermissionToUser(userCreated.getId(), 1);
		
		return new ResponseEntity<User>(userCreated, HttpStatus.CREATED);
	}

	

	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		Optional<User> categoria = userService.findById(id);

		return categoria.isPresent() ? ResponseEntity.ok(categoria.get()) : ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}/ativo")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_DISABLE_USER') and hasAuthority('SCOPE_write')")
	public void atualizarPropriedadeAtivo(@PathVariable Long id, @RequestBody Boolean ativo) {
		userService.updatePropertyActive(id, ativo);
	}
	
	@GetMapping
	public ResponseEntity<Page<User>> getAll(SpecificationTemplate.UserSpec spec,
											@PageableDefault(page = 0, size = 10, sort = "id", 
												direction = Sort.Direction.ASC) Pageable pageable) {

		return ResponseEntity.ok(userService.findAll(spec, pageable));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		
		Optional<User> user = userService.findById(id);
		
		if(!user.isPresent()) {
			throw new UserNotFoundException();
		}
		
		userService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	private String BCryptPasswordEncoder(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(encoder.encode(password));
		
		return encoder.encode(password);
		
	}
	
	@ExceptionHandler({ CepInvalidoException.class })
	public ResponseEntity<Object> handleCepInvalidoException(CepInvalidoException ex) {
		String mensagemUsuario = messageSource.getMessage("cep.invalido", null, LocaleContextHolder.getLocale());
		String mensagemDesenvolvedor = ex.toString();
		List<Erro> erros = Arrays.asList(new Erro(mensagemUsuario, mensagemDesenvolvedor));
		return ResponseEntity.badRequest().body(erros);
	}

}
