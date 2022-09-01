package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<ErrorMessage> handlerAlreadyExistException(ResourceAlreadyExistException resourceAlreadyExistException){
        ErrorMessage errorMessage=new ErrorMessage();
        errorMessage.setStatusCode(String.valueOf(HttpStatus.CONFLICT));
        errorMessage.setMessage(resourceAlreadyExistException.getMessage());
        errorMessage.setDate(new Date());
        return new ResponseEntity<>(errorMessage, HttpStatus.CONFLICT);
    }
}
