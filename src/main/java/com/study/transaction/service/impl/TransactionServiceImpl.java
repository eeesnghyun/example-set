package com.study.transaction.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.transaction.dao.TransactionDAO;
import com.study.transaction.service.TransactionService;
import com.study.transaction.vo.TransactionVO;

@Service("transaction.TransactionService")
public class TransactionServiceImpl implements TransactionService {

	@Inject
	TransactionDAO transactionDAO;

	@Override
	public void insertEx01(TransactionVO transactionVO) throws Exception {
		transactionDAO.insertData(transactionVO);	// Success

		transactionDAO.insertNull();				// Error! Roll back
	}

}