package com.tyy.educationadminsystem.common.exception;

public class BusinessException  extends RuntimeException{
    public BusinessException(){

    }
    public BusinessException(String reason){
        super(reason);
    }
}
