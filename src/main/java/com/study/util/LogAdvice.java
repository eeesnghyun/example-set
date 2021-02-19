package com.study.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.study.transaction.vo.TransactionVO;

@Aspect
public class LogAdvice {

	private static final Logger logger = LoggerFactory.getLogger(LogAdvice.class);

	@Pointcut("execution(* com.study.transaction.service.impl.*Impl.*(..))")
	private static void advicePoint() {}

	@Before("advicePoint()")
	public void logBefore(JoinPoint joinPoint) {
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		logger.info("### Before - Method : " + methodSignature.toString());

		for(Object arg : joinPoint.getArgs()) {
		      if(arg instanceof TransactionVO) {
		    	TransactionVO transactionVO = (TransactionVO) arg;

		    	logger.info("VO/DTO   => " + transactionVO);
		    	logger.info("testno   => " + transactionVO.getTestno());
		    	logger.info("testname => " + transactionVO.getTestname());
		      } else {
		    	logger.info(arg.toString());
		      }
		}
	}

	@After(value="advicePoint()")
	public void logAfter(JoinPoint joinPoint) {
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		logger.info("### After - Method : " + methodSignature.toString());

		for(Object arg : joinPoint.getArgs()) {
		      if(arg instanceof TransactionVO) {
		    	TransactionVO transactionVO = (TransactionVO) arg;

		    	logger.info("VO/DTO   => " + transactionVO);
		    	logger.info("testno   => " + transactionVO.getTestno());
		    	logger.info("testname => " + transactionVO.getTestname());
		      } else {
		    	logger.info(arg.toString());
		      }
		}
	}

	@AfterReturning(value="advicePoint()", returning="msg")
	public void logAfterReturn(JoinPoint joinPoint, String msg) {
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		logger.info("### AfterReturning - Method : " + methodSignature.toString());

		for(Object arg : joinPoint.getArgs()) {
		      if(arg instanceof TransactionVO) {
		    	TransactionVO transactionVO = (TransactionVO) arg;

		    	logger.info("VO/DTO   => " + transactionVO);
		    	logger.info("testno   => " + transactionVO.getTestno());
		    	logger.info("testname => " + transactionVO.getTestname());
		    	logger.info("return msg => " + msg);
		      } else {
		    	logger.info(arg.toString());
		      }
		}
	}
}