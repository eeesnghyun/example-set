package com.study.exception;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionController {

	private static final Logger logger = LoggerFactory.getLogger(ExceptionController.class);

	@RequestMapping(value = "/exception/ex01.do", method = RequestMethod.GET)
	public String ex01(Locale locale, Model model) {
		logger.info("### Request URL : /exception/ex01.do");
		return "/exception/ex01";
	}	
	
	@RequestMapping(value = "/exception/ex02.do", method = RequestMethod.GET)
	public String ex02(Locale locale, Model model) {
		logger.info("### Request URL : /exception/ex02.do");
		return "/exception/ex02";
	}	
	
	@RequestMapping(value = "/exception/sqlExceptionGet.do", method = { RequestMethod.GET })
	public ModelAndView sqlExceptionGet(HttpServletRequest reqest) throws Exception {	
		ModelAndView mav = new ModelAndView();				
		
		String msg = reqest.getParameter("msg");
			
		if("Y".equals(msg)) {
			throw new CustomSqlException("예외 발생");
		} else {
			msg = "통과";
		}
		
		mav.addObject("msg", msg);
		mav.setViewName("/common/message");
		
		return mav;	
	}
	
	@RequestMapping(value = "/exception/sqlExceptionPost.do", method = { RequestMethod.POST })
	public @ResponseBody Map<String, Object> sqlExceptionPost(HttpServletRequest reqest, @RequestBody String jsonParam) throws Exception {
		JSONObject result = new JSONObject(); 
		
		try {
			JSONObject json = (JSONObject) JSONValue.parse(jsonParam);
			
			String msg = (String) json.get("msg");
			
			if("Y".equals(msg)) {
				throw new Exception();
			} else {
				result.put("msg", "통과");			
			}						
		} catch (Exception e) {
			// TODO: handle exception
			throw new CustomSqlException("예외 발생");
		}				
		
		return result;	
	}
}
