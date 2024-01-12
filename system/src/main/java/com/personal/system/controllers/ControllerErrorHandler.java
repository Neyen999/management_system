package com.personal.system.controllers;

import com.personal.system.exceptions.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
@RestController
public class ControllerErrorHandler {
    public ControllerErrorHandler() {
    }

    @ExceptionHandler({CustomException.class})
    public ResponseEntity<CustomException> handleCustomException(CustomException ex) {
        return this.createErrorResponse(ex);
    }

    private ResponseEntity<CustomException> createErrorResponse(CustomException ex) {
        return new ResponseEntity(ex, ex.getHttpStatus());
    }
}
