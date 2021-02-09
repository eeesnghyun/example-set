package com.study.xss;

import java.util.Locale;

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

import com.nhncorp.lucy.security.xss.XssPreventer;

@Controller
public class XssController {

	private static final Logger logger = LoggerFactory.getLogger(XssController.class);

	@RequestMapping(value = "/xss/ex01.do", method = RequestMethod.GET)
	public String ex01(Locale locale, Model model) {
		logger.info("### Request URL : /xss/ex01.do");
		return "/xss/ex01";
	}
	
	@RequestMapping(value = "/xss/ex02.do", method = RequestMethod.GET)
	public String ex02(Locale locale, Model model) {
		logger.info("### Request URL : /xss/ex02.do");
		return "/xss/ex02";
	}
	
	@RequestMapping(value = "/xss/ex03.do", method = RequestMethod.GET)
	public String ex03(Locale locale, Model model) {
		logger.info("### Request URL : /xss/ex03.do");
		return "/xss/ex03";
	}

	@RequestMapping(value = "/xss/useFilter.do", method = { RequestMethod.POST })
	public ModelAndView useFilter(HttpServletRequest request) throws Exception {	
		ModelAndView mav = new ModelAndView();				
		
		String inputMsg   = request.getParameter("inputMsg");
		String convertMsg = XssPreventer.unescape(inputMsg);
		
		logger.info("### Get Message(Use XSS Filter) ###");
		logger.info("### 치환 => " + inputMsg);
		logger.info("### 역치환 => " + convertMsg);
		
		mav.addObject("msg", inputMsg);
		mav.setViewName("/common/message");
		
		return mav;	
	}
	
	@RequestMapping(value = "/xss/noneFilter.do", method = { RequestMethod.POST })
	public ModelAndView noneFilter(HttpServletRequest request) throws Exception {	
		ModelAndView mav = new ModelAndView();
		
		String inputMsg   = request.getParameter("inputMsg");
		
		logger.info("### Get Message(None XSS Filter) ###");
		logger.info("### => " + inputMsg);
		
		mav.addObject("msg", inputMsg);
		mav.setViewName("/common/message");
		
		return mav;	
	}
		
	@RequestMapping(value = "/xss/globalFilter.do", method = { RequestMethod.POST })
	public ModelAndView globalFilter(HttpServletRequest request) throws Exception {	
		ModelAndView mav = new ModelAndView();
		
		String nParam = request.getParameter("nParam");
		String nMsg   = request.getParameter("nMsg");
		String msg    = request.getParameter("msg");
		
		logger.info("### Get Message(<global> 태그 사용) ###");
		logger.info("### nParam => " + nParam);
		logger.info("### nMsg => " + nMsg);
		logger.info("### msg => " + msg);
		
		mav.addObject("nParam", nParam);
		mav.addObject("nMsg"  , nMsg);
		mav.addObject("msg"   , msg);
		mav.setViewName("/xss/ex02_1");
		
		return mav;	
	}
	
	@RequestMapping(value = "/xss/jsonFilter.do", method = { RequestMethod.POST })
	public @ResponseBody JSONObject sqlExceptionPost(@RequestBody String jsonParam) throws Exception {
		JSONObject result = new JSONObject(); 
		
		JSONObject json = (JSONObject) JSONValue.parse(jsonParam);
		
		String msg = (String) json.get("msg");
		
		logger.info("### Get Message(JSON 데이터) ###");
		logger.info("### => " + msg);
		
		result.put("msg", msg);
		
		return result;	
	}
}