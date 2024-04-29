package com.example.cabdriver.exceptionhandling;

import com.example.cabdriver.exceptionhandling.exception.EntityAlreadyExists;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityAlreadyExists.class)
    public ResponseEntity<String> handleEntityAlreadyExistsException(EntityAlreadyExists e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
