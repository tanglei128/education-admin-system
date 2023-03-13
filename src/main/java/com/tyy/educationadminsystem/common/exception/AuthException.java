package com.tyy.educationadminsystem.common.exception;

public class AuthException extends RuntimeException{
    public AuthException(){}
    public AuthException(String msg){
        super(msg);
    }
}
