package com.exceptionhandling.springexceptionhandling.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler({NotFoundCarException.class})
    public String  responseNotFoundEntity(){
        return "Car is not found in list...";
    }

    @ExceptionHandler({IllegalArgumentException.class})
    public String  illegalArgumentException(){
        return "Wrong parameter...";
    }
}
