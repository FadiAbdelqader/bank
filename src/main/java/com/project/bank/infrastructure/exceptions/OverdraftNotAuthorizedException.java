package com.project.bank.infrastructure.exceptions;

public class OverdraftNotAuthorizedException extends RuntimeException{
    public OverdraftNotAuthorizedException(String message) {
        super(message);
    }
}
