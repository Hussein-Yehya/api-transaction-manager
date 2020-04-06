package io.pismo.api.transaction.manager.exception;

import org.springframework.http.HttpStatus;

import java.util.function.Supplier;

public class ExceptionBuilder {

    public static Supplier<ApiException> buildExceptionHandler(HttpStatus status, String message) {
        return () -> new ApiException(status.name(),
                message,
                status.value());
    }
}
