package com.study.exception;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@RestControllerAdvice
public class CustomExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);

	@ExceptionHandler(CustomSqlException.class)
	private ModelAndView customSqlException(HttpServletRequest request, CustomSqlException ex) {				
		String msg = ex.getMessage();
		
		logger.error("### CustomSqlException");
		logger.error("### 메세지 : " + msg);				
				
		if(isAjaxRequest(request)) {
			return createJsonView(msg); 
		}
		
		ModelAndView mav = new ModelAndView();		
		
		mav.addObject("msg", msg);
		mav.setViewName("/common/message");
		
		return mav;	
	}
	
	private boolean isAjaxRequest(HttpServletRequest request) {		
		String header = request.getHeader("x-requested-with");		
		
		logger.info("### Request Header : " + request.getHeader("x-requested-with"));
		
		if("XMLHttpRequest".equals(header)) { 
			return true;
		}
		
		return false;
	}
	
	private ModelAndView createJsonView(String msg) { 
		ModelAndView mav = new ModelAndView("jsonView"); 
		
		mav.addObject("msg", msg);
		
		return mav; 
	}
	
	@Bean 
	public MappingJackson2JsonView jsonView() {
		return new MappingJackson2JsonView(); 
	}
}
