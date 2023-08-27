package com.project1be01.service.validation;

public class IsAlreadyExistException extends RuntimeException{

    public IsAlreadyExistException(String message) {
        super(message);
    }
}
