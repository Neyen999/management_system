package com.personal.system.controllers;

//import com.asaplibs.errorHandling.exception.CustomException;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.NoHandlerFoundException;

//@RestController
//@ControllerAdvice
//@Order(1)
//public class SpecificExceptionHandler {
//
//    @ExceptionHandler(NullPointerException.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public CustomException handleNullPointerException(NullPointerException ex) {
//        // Log the exception and return a custom error page
//      CustomException exception = new CustomException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), "No se pudo realizar el llamado porque el metodo devuelve null.");
//
//      return exception;
//    }
//
//    @ExceptionHandler(NoHandlerFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public CustomException handleNoHandlerFoundException(HttpServletRequest request, Exception ex) {
//        // Log the exception and return a custom 404 page
//        CustomException exception = new CustomException(HttpStatus.NOT_FOUND, ex.getMessage(), "No se encontro un handler.");
//
//        return exception;
//    }
//
//
//    @ExceptionHandler(MismatchedInputException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public CustomException handleBadRequest(MismatchedInputException e) {
//        String fieldError = e.getPath().get(0).getDescription();
//
//        Object data = e.getPath().get(0).getDescription();
//
//        CustomException exception = new CustomException(HttpStatus.BAD_REQUEST, e.getMessage(), fieldError);
//
//        return exception;
//    }
//
//    @ExceptionHandler(DataIntegrityViolationException.class)
//    @ResponseStatus(HttpStatus.CONFLICT)
//    public CustomException handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
//        // Log the exception and return a custom error page
//        CustomException exception = new CustomException(HttpStatus.CONFLICT, ex.getMessage(), "Se ha producido una violación de la integridad de los datos");
//
//        return exception;
//    }
//
//    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
//    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
//    public CustomException handleHttpRequestMethodNotSupportedException(HttpServletRequest request, HttpRequestMethodNotSupportedException ex) {
//        // Log the exception and return a custom error page
//        CustomException exception = new CustomException(HttpStatus.METHOD_NOT_ALLOWED, ex.getMessage(), "El método HTTP solicitado no está soportado por el controlador");
//
//        return exception;
//    }
//
//    @ExceptionHandler(MaxUploadSizeExceededException.class)
//    @ResponseStatus(HttpStatus.PAYLOAD_TOO_LARGE)
//    public CustomException handleMaxUploadSizeExceededException(HttpServletRequest request, MaxUploadSizeExceededException ex) {
//        // Log the exception and return a custom error page
//        CustomException exception = new CustomException(HttpStatus.PAYLOAD_TOO_LARGE, ex.getMessage(), "El archivo que intenta subir supera el tamaño máximo permitido");
//
//        return exception;
//    }
//}

