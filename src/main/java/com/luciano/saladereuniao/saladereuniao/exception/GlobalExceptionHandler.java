package com.luciano.saladereuniao.saladereuniao.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException e, WebRequest request) {
        ErrorDatails errorDatails = new ErrorDatails(new Date(), e.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDatails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globlaExceptionHandler(Exception e, WebRequest request) {
        ErrorDatails errorDatails = new ErrorDatails(new Date(), e.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDatails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
