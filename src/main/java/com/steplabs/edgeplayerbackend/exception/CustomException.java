package com.steplabs.edgeplayerbackend.exception;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {
    String message;
    HttpStatus httpStatus;

    public CustomException(HttpStatus hStatus,String mes)
    {
        this.message=mes;
        this.httpStatus=hStatus;

    }


    @Override
    public String getMessage(){return message;}

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
