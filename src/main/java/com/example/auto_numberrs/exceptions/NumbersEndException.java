package com.example.auto_numberrs.exceptions;

public class NumbersEndException extends RuntimeException {
    public NumbersEndException() {
    }

    public NumbersEndException(String message) {
        super(message);
    }

    public NumbersEndException(String message, Throwable cause) {
        super(message, cause);
    }
}
