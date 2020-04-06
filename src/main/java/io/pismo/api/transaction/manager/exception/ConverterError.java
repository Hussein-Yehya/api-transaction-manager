package io.pismo.api.transaction.manager.exception;

public class ConverterError extends Exception {

	private static final long serialVersionUID = 1L;

	private String message;

	public ConverterError(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}

}
