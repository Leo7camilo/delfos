package com.delfos.services.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.delfos.services.CepService;

@Service
public class CepServiceImpl implements CepService{
	
	
	@Value("${api.via.cep}")
	private String urlViaCEP;
	

	@Override
	public boolean findCep(String cep) {
		
		boolean isCepValid = false;
		
		RestTemplate restTemplate = new RestTemplate();
		
		
		String urlCompleted = urlViaCEP + cep + "//json";
		cep = cep.replace("-", "").replace(".", "");
		System.out.println(urlCompleted);
		
		
		String response = restTemplate.getForObject(urlCompleted, String.class);
		
		try {
			if(response.contains("cep")) {
				isCepValid = true;
			}
		}catch (Exception ex) {}
		
		return isCepValid;
	}
	
	

}
