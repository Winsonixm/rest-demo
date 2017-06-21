package com.example.exceptions;


@SuppressWarnings("serial")
public class DataIntegrityViolationException extends RuntimeException {
    public DataIntegrityViolationException(String msg) {
        super(msg);
    }
}
