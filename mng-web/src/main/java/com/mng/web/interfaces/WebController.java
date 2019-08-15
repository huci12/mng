package com.mng.web.interfaces;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {

	@GetMapping("/")
	public ModelAndView index(ModelAndView mav) {
		System.out.println("1234");
		mav.setViewName("/login");
		return mav;
	}
}
