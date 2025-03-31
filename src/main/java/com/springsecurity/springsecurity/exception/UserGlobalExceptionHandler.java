package com.springsecurity.springsecurity.exception;

import com.springsecurity.springsecurity.response.UserErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserGlobalExceptionHandler extends RuntimeException{
    @ExceptionHandler
    public ResponseEntity<UserErrorResponse> handleException(final UserNotFoundException e){
        UserErrorResponse userErrorResponse = new UserErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userErrorResponse);
    }

    @ExceptionHandler
    public ResponseEntity<UserErrorResponse> handleException(final UserDuplicateException e){
        UserErrorResponse userErrorResponse = new UserErrorResponse(HttpStatus.CONFLICT.value(), e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(userErrorResponse);
    }
}
