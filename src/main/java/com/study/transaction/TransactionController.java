package com.study.transaction;

import java.util.Locale;

import javax.annotation.Resource;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.study.exception.CustomSqlException;
import com.study.transaction.service.TransactionService;
import com.study.transaction.vo.TransactionVO;

@Controller
public class TransactionController {

	private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);

	@Resource(name = "transaction.TransactionService")
	private TransactionService transactionService;

	@RequestMapping(value = "/transaction/ex01.do", method = RequestMethod.GET)
	public String ex01(Locale locale, Model model) {
		logger.info("### Request URL : /transaction/ex01.do");
		return "/transaction/ex01";
	}

	@RequestMapping(value = "/transaction/testTransaction.do", method = { RequestMethod.POST })
	public @ResponseBody JSONObject testTransaction(@RequestBody String jsonParam) throws Exception {
		Gson gson = new Gson();
		JSONObject result = new JSONObject();
		TransactionVO transactionVO = new TransactionVO();

		try {
			transactionVO = gson.fromJson(jsonParam, TransactionVO.class);

			transactionService.insertEx01(transactionVO);

			result.put("msg", "SUCCESS");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

			//throw new CustomSqlException("ERROR");
			result.put("msg", "ERROR");
		}
		return result;
	}
}
