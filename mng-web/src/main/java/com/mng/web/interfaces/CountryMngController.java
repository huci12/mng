package com.mng.web.interfaces;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CountryMngController {
	
	@GetMapping("/view/country/countryMain")
	public ModelAndView countryMain(HttpServletRequest req , ModelAndView mav) {
		mav.setViewName("/view/country/countryMain");
		return mav;
	}
}
