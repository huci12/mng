package com.mng.web.interfaces;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {
	private static final Logger logger = LogManager.getLogger(WebController.class);
	@GetMapping("/")
	public ModelAndView index(ModelAndView mav) {
		logger.info("로그인창으로 들어 옵니다.");
		mav.setViewName("/login");
		return mav;
	}
	
	@GetMapping("/view/main/main")
	public ModelAndView mainPage(HttpServletRequest req, ModelAndView mav) {
		logger.info("메인 들어 옵니다.");
		mav.setViewName("/view/main/main");
		return mav;
	}
}
