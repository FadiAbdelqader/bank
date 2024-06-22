package com.project.bank.infrastructure.exceptions;

public class OverdraftExceededException extends RuntimeException{
    public OverdraftExceededException(String message) {
        super(message);
    }
}
