//package com.example.controller.exception;
//
//import com.alibaba.fastjson.JSONObject;
//import com.example.controller.Enum.ResultCode;
//import com.example.controller.JsonMessage;
//import feign.Response;
//import feign.Util;
//import feign.codec.ErrorDecoder;
//import lombok.extern.slf4j.Slf4j;
//
///**
// * @author xuzihan
// * @version 1.0
// * @description: TODO
// * @data
// **/
//@Slf4j
//public class FeignErrorDecoder implements ErrorDecoder {
//    @Override
//    public Exception decode(String s, Response response) {
//        OpException exception = null;
//        try{
//            String errorContent = Util.toString(response.body().asReader());
//            JsonMessage result = JSONObject.parseObject(errorContent, JsonMessage.class);
//            exception = new OpException(result.getCode(), result.getDesc());
//        }catch (Exception e){
//            log.error("处理FeignClient 异常错误");
//            e.printStackTrace();
//            exception = new OpException(ResultCode.UNFROSEEN_ERROR.getCode(),ResultCode.UNFROSEEN_ERROR.getDesc());
//        }
//        return exception;
//    }
//}
