package com.study.transaction.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.transaction.vo.TransactionVO;

@Repository("TransactionDAO")
public class TransactionDAO {

	@Autowired
	private SqlSession sqlSession;

	public void insertData(TransactionVO transactionVO) {
		sqlSession.insert("transaction.insertData", transactionVO);
	}

	public void insertNull() {
		sqlSession.insert("transaction.insertNull");
	}
}