package com.personal.system.controllers;

import com.personal.system.exceptions.CustomException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
@Order(2)
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public CustomException handleAllExceptions(Exception ex) {
        // Log the exception and return a generic error page
        CustomException exception = new CustomException(HttpStatus.INTERNAL_SERVER_ERROR, ex);

        return exception;
    }
}
