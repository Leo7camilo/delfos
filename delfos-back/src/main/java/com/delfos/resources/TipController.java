package com.delfos.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delfos.model.Tip;
import com.delfos.model.User;
import com.delfos.services.TipService;
import com.delfos.specification.SpecificationTemplate;

@RestController
@RequestMapping("/${api.version}/tip")
public class TipController {
	
	
	@Autowired
	TipService tipService;
	
	@GetMapping
	public ResponseEntity<Page<Tip>> getAll(SpecificationTemplate.TipSpec spec,
											@PageableDefault(page = 0, size = 10, sort = "id", 
												direction = Sort.Direction.ASC) Pageable pageable) {

		return ResponseEntity.ok(tipService.findAll(spec, pageable));
	}

}
