package com.springsecurity.springsecurity.exception;

public class UserDuplicateException extends RuntimeException{
    public UserDuplicateException(String message) {
        super(message);
    }
}
