package io.pismo.api.transaction.manager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

@RestControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiError> handleAll(Exception e, HttpStatus status) {

		return ResponseEntity.status(status).body(new ApiError(e, status));
	}

	@ExceptionHandler(ApiException.class)
	public ResponseEntity<ApiError> apiException(ApiException e) {

		return ResponseEntity.status(e.getStatusCode()).body(new ApiError(e, e.getStatusCode()));
	}

	@ExceptionHandler(InternalServerErrorException.class)
	public ResponseEntity<ApiError> internalServerError(InternalServerErrorException e) {
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

		ApiError err = new ApiError(status.value(), e.getCode(), e.getDescription());

		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationError> fieldValidationError(MethodArgumentNotValidException e) {
		HttpStatus status = HttpStatus.BAD_REQUEST;

		ValidationError err = new ValidationError(status.value(), "Validation error", e.getMessage());

		for (FieldError x : e.getBindingResult().getFieldErrors()) {
			err.addError(x.getField(), x.getDefaultMessage());
		}

		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ApiError> jsonValidationError(HttpMessageNotReadableException e) {
		HttpStatus status = HttpStatus.BAD_REQUEST;

		ApiError err = new ApiError(status.value(), "Invalid JSON request", e.getMessage());

		return ResponseEntity.status(status).body(err);
	}

}
