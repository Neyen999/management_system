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

    @ExceptionHandler({HttpClientErrorException.Forbidden.class})
    public ResponseEntity<CustomException> handleCustomBadRequestException(HttpClientErrorException.Forbidden ex) {
        CustomException exceptionDetail = new CustomException(HttpStatus.FORBIDDEN);
        return new ResponseEntity(exceptionDetail, HttpStatus.FORBIDDEN);
    }
//
//    @ExceptionHandler({NotFoundException.class})
//    public ResponseEntity<CustomException> handleCustomNotFoundException(NotFoundException ex) {
//        CustomException exceptionDetail = new CustomException(ex.getErrorProvider(), HttpStatus.NOT_FOUND);
//        return new ResponseEntity(exceptionDetail, HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler({ProcessingException.class})
//    public ResponseEntity<CustomException> handleCustomProcessingException(ProcessingException ex) {
//        CustomException exceptionDetail = new CustomException(ex.getErrorProvider(), HttpStatus.INTERNAL_SERVER_ERROR);
//        return new ResponseEntity(exceptionDetail, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
}
