package com.mng.api.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryApiController {

	@GetMapping("/api/countryList")
	public ResponseEntity<?> getCountryList(){
		System.out.println("11");
		return null;
	}
}
