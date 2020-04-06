package io.pismo.api.transaction.manager.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends ApiError {

    private List<FieldMessage> errors;

    public ValidationError(Integer status, String error, String message) {
        super(status, error, message);
        errors = new ArrayList<>();
    }

    public void addError(String field, String message) {
        errors.add(new FieldMessage(field, message));
    }

    public List<FieldMessage> getErrors() {
        return this.errors;
    }

}
