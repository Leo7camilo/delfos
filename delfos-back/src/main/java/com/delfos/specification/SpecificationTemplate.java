package com.delfos.specification;

import org.springframework.data.jpa.domain.Specification;

import com.delfos.model.Tip;
import com.delfos.model.User;

import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;

public class SpecificationTemplate {
	
	
	@And({
		@Spec(path = "type", spec = Equal.class),
		@Spec(path = "documentNumber", spec = Equal.class),
		@Spec(path = "email", spec = Like.class),
	})
	
	public interface UserSpec extends Specification<User>{}
	
	
	@And({
		@Spec(path = "value", spec = Like.class),
	})
	
	public interface TipSpec extends Specification<Tip>{}

}
