package com.personal.system.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class CustomException extends RuntimeException {
    private HttpStatus httpStatus;
    private int httpStatusCode;
    private int errorCode;
    private String path;
    private String fieldLocation;

    public CustomException() {
        this.printStackTrace();
    }

    public CustomException(HttpStatus httpStatus, Exception e) {
        super(e.getMessage());
        this.httpStatus = httpStatus;
        this.httpStatusCode = httpStatus.value();
        this.path = getUriFromRequest();
//        this.errorLocation = e.getCause().;
        this.printStackTrace();
    }

    public CustomException(HttpStatus httpStatus, Exception e, String fieldLocation) {
        super(e.getMessage());
        this.httpStatus = httpStatus;
        this.httpStatusCode = httpStatus.value();
        this.path = getUriFromRequest();
        this.fieldLocation = fieldLocation;
        this.printStackTrace();
    }

    public CustomException(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        this.httpStatusCode = httpStatus.value();
        this.printStackTrace();
    }

//    public CustomException(HttpStatus httpStatus, String message, String fieldLocation) {
//        this.httpStatus = httpStatus;
//        this.httpStatusCode = httpStatus.value();
//        this.path = path;
//        this.fieldLocation = fieldLocation;
//        this.printStackTrace();
//    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }

    public int getHttpStatusCode() {
        return this.httpStatusCode;
    }

    public void setHttpStatus(final HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public void setHttpStatusCode(final int httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public void setErrorCode(final int errorCode) {
        this.errorCode = errorCode;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFieldLocation() {
        return fieldLocation;
    }

    public void setFieldLocation(String fieldLocation) {
        this.fieldLocation = fieldLocation;
    }

    private String getUriFromRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        String uri = request.getRequestURI();

        return uri;

    }
}
