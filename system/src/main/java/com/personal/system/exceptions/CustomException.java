package com.personal.system.exceptions;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {
//    private ErrorCodeProvider errorProvider;
    private HttpStatus httpStatus;
    private int httpStatusCode;
    private int errorCode;


    public CustomException() {
//        super(errorProvider.getErrorMessage());
//        this.errorProvider = errorProvider;
//        this.errorCode = errorProvider.getErrorCode();
        this.printStackTrace();
    }

    public CustomException(HttpStatus httpStatus) {
//        super(errorProvider.getErrorMessage());
//        this.errorProvider = errorProvider;
//        this.errorCode = errorProvider.getErrorCode();
        this.httpStatus = httpStatus;
        this.httpStatusCode = httpStatus.value();
        this.printStackTrace();
    }

//    public ErrorCodeProvider getErrorProvider() {
//        return this.errorProvider;
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

//    public void setErrorProvider(final ErrorCodeProvider errorProvider) {
//        this.errorProvider = errorProvider;
//    }

    public void setHttpStatus(final HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public void setHttpStatusCode(final int httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public void setErrorCode(final int errorCode) {
        this.errorCode = errorCode;
    }
}
