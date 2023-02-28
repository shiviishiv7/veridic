package com.example.veridic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(RecordNotFound.class)
    public ResponseEntity<ErrorResponse> errorRecordNotFound(RecordNotFound recordNotFound) {
        long currentTimeMillis = System.currentTimeMillis();
        ErrorResponse errorResponse = new ErrorResponse(recordNotFound.getMessage(),
                HttpStatus.NOT_FOUND.value(), currentTimeMillis);
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
