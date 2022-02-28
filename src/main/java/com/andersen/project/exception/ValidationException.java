package com.andersen.project.exception;

/**
 * Author Vladislav Domaniewski 24_99 (c)
 * For company Andersen
 */

public class ValidationException extends Exception {
    private String message;

    public ValidationException(String message) {
    }
    public String getMessage() {
        return message;
    }
}
