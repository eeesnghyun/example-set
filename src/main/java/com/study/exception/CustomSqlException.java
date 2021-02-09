package com.study.exception;

@SuppressWarnings("serial")
public class CustomSqlException extends Exception {
	
	public CustomSqlException(String msg) {
        super(msg);
    }
}