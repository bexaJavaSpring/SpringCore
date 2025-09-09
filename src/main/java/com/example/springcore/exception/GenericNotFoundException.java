package com.example.springcore.exception;

public class GenericNotFoundException extends RuntimeException {
    public GenericNotFoundException(String message) {
        super(message);
    }

    public GenericNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
