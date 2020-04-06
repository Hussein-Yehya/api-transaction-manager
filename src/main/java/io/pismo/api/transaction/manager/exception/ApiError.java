package io.pismo.api.transaction.manager.exception;

import java.util.Objects;
import java.util.stream.Stream;

import org.springframework.http.HttpStatus;

public class ApiError {

	private Integer status;
	private String error;
	private String message;

	public ApiError(Integer status, String error, String message) {
		super();
		this.status = status;
		this.error = error;
		this.message = message;
	}

	public ApiError(Exception e, HttpStatus status) {

		this.status = status.value();
		this.error = status.name();
		this.message = Objects.isNull(e.getMessage()) ? "" : e.getMessage();
	}

	public ApiError(ApiException e, Integer status) {
		this.status = status;
		this.error = Stream.of(HttpStatus.values()).filter(s -> status.equals(s.value())).findFirst().get().name();
		this.message = Objects.isNull(e.getMessage()) ? "" : e.getMessage();
	}

	public String getError() {
		return this.error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
