package com.delfos.resources;

import java.time.LocalDate;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delfos.dtos.UserDto;
import com.delfos.model.Tip;
import com.delfos.model.User;
import com.delfos.services.TipService;
import com.delfos.services.exception.CepInvalidoException;
import com.delfos.specification.SpecificationTemplate;

@RestController
@RequestMapping("/${api.version}/tip")
public class TipController {
	
	
	@Autowired
	TipService tipService;
	
	
	
	@PostMapping
	public ResponseEntity<Tip> createTip(@Valid @RequestBody Tip tip) {

		Tip tipCreated = tipService.createTip(tip);
		return new ResponseEntity<Tip>(tipCreated, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Tip> findById(@PathVariable Long id) {
		Optional<Tip> tip = tipService.findById(id);

		return tip.isPresent() ? ResponseEntity.ok(tip.get()) : ResponseEntity.notFound().build();
	}
	
	@GetMapping
	public ResponseEntity<Page<Tip>> getAll(SpecificationTemplate.TipSpec spec,
											@PageableDefault(page = 0, size = 10, sort = "id", 
												direction = Sort.Direction.ASC) Pageable pageable) {

		return ResponseEntity.ok(tipService.findAll(spec, pageable));
	}
	
	
	

}
