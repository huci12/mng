package com.mng.web.interfaces;


import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController{

	private static final String PATH = "/error";
	
	
	//javax.servlet.error.status_code
	//- 에러 상태 코드 출력
	//javax.servlet.error.exception_type
	//- 예외처리 클래스 출력
	//javax.servlet.error.message
	//- 오류 메세지 출력
	//javax.servlet.error.request_uri
	//- 문제가 되는 request uri 정보를 출력
	//javax.servlet.error.exception
	//- 발생한 예외처리 내용 출력
	//javax.servlet.error.servlet_name
	//- 에러가 난 서블릿 명 출력
	
	@RequestMapping(value=PATH)
	public String getErrorPath(HttpServletRequest request) {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		HttpStatus httpStatus = HttpStatus.valueOf(Integer.valueOf(status.toString()));
		System.out.println(status.toString());
		 System.out.println("code = " + status.toString());
	     System.out.println("msg = " + httpStatus.getReasonPhrase()); 
	     System.out.println("timestamp = " + new Date());
        if (status.toString().equals("404")) {
            return "/error/404"; // /WEB-INF/errors/404.jsp
        }else {
        	return "/error/500";
        }
        
	}

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return PATH;
	}

	
	
}
