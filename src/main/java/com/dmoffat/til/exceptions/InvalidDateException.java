package com.dmoffat.til.exceptions;

public class InvalidDateException extends RuntimeException {
	
	private static final long serialVersionUID = -4798528835743217239L;
	
	public InvalidDateException(String msg) {
		super(msg);
	}

}
