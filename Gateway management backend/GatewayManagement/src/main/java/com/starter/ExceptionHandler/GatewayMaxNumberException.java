package com.starter.ExceptionHandler;

import org.springframework.http.HttpStatus;

public class GatewayMaxNumberException extends APIexceptions {

	private static final long serialVersionUID = 1L;

	public GatewayMaxNumberException(String message) {
		super(message);
	}

	protected HttpStatus getHttpStatus() {

		return HttpStatus.NOT_ACCEPTABLE;
	}
}
