package com.mng.web.interfaces;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CountryMngController {
	private static final Logger logger = LogManager.getLogger(CountryMngController.class);
	
	@GetMapping("/view/country/countryMain")
	public ModelAndView countryMain(HttpServletRequest req , ModelAndView mav) {
		mav.setViewName("/view/country/countryMain");
		return mav;
	}
}
