package com.starter.ExceptionHandler;

import org.springframework.http.HttpStatus;

public class PatternException extends APIexceptions{

	private static final long serialVersionUID = 1L;

	public PatternException(String message) {
		super(message);
	}

	protected HttpStatus getHttpStatus() {

		return HttpStatus.BAD_REQUEST;
	}
}
