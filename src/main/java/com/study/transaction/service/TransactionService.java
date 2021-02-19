package com.study.transaction.service;

import com.study.transaction.vo.TransactionVO;

public interface TransactionService {

	public void insertEx01(TransactionVO transactionVO) throws Exception;

	public String insertEx02(TransactionVO transactionVO) throws Exception;
}