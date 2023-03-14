package com.tyy.educationadminsystem.result;

import lombok.Data;

@Data
public class ResponseResult<T> extends BaseResponse{
    private T data;

    public static<T> ResponseResult success(T data){

        return createResult(RespCode.SUCCESS.getCode(),RespCode.SUCCESS.getMessage(),data);
    }
    public static<T> ResponseResult success(){

        return createResult(RespCode.SUCCESS.getCode(),RespCode.SUCCESS.getMessage());
    }
    public static<T> ResponseResult success(String msg){

        return createResult(RespCode.SUCCESS.getCode(),msg);
    }

    public static<T> ResponseResult error(String msg){

        return createResult(RespCode.FAILED.getCode(),msg);
    }
    public static<T> ResponseResult error(String code,String msg){

        return createResult(code,msg);
    }
    public static<T> ResponseResult error(){

        return createResult(RespCode.FAILED.getCode(),RespCode.FAILED.getMessage());
    }

    private static <T> ResponseResult<T> createResult(String code,String msg,T data){
        ResponseResult<T> result = new ResponseResult<>();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }
    private static <T> ResponseResult<T> createResult(String code,String msg){
        ResponseResult<T> result = new ResponseResult<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
