package com.example.controller.exception;

import com.example.controller.Enum.ResultCode;
import com.example.controller.JsonMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xuzihan
 * @version 1.0
 * @description: 异常处理
 * @data 2021/3/30
 **/
@RestControllerAdvice
public class ExceptionHandle {
    Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Throwable.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Object handleConstraintDeclarationException(Exception e, HttpServletRequest req){
        logger.error(e.getMessage());
//        e.printStackTrace();
        return new JsonMessage<String>(e.getMessage(),ResultCode.UNFROSEEN_ERROR.getCode(),ResultCode.UNFROSEEN_ERROR.getDesc());
    }

    @ExceptionHandler(value = {OpException.class})
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Object handleException(OpException e, HttpServletRequest req) {
        logger.error(e.getMessage());
//        e.printStackTrace();
        return new JsonMessage<String>("系统错误",e.getErrorCode(),e.getMessage());
    }

}
