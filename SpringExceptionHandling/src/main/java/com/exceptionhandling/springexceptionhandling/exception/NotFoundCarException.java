package com.exceptionhandling.springexceptionhandling.exception;

public class NotFoundCarException extends RuntimeException{

    public NotFoundCarException(String  param){
        super(param);
    }

}
