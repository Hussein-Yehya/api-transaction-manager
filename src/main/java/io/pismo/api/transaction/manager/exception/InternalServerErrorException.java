package io.pismo.api.transaction.manager.exception;

import org.springframework.http.HttpStatus;

public class InternalServerErrorException extends ApiException {

	private static final long serialVersionUID = 1L;
	private static final String INTERNAL_ERROR_CODE = "internal_error";

	public InternalServerErrorException(String message, Throwable e) {
		super(INTERNAL_ERROR_CODE, message, HttpStatus.INTERNAL_SERVER_ERROR.value(), e);
	}

}
