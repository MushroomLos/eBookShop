package com.example.controller.controller;

import com.example.controller.service.TestConsumerService;
import feign.FeignException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;

import javax.annotation.Resource;

/**
 * @author xuzihan
 * @version 1.0
 * @description: TODO
 * @data
 **/
@RestController
public class TestConsumerController {
    @Resource
    private TestConsumerService testService;

    @RequestMapping(value = "getTest")
    public String getTest(){
        return testService.getProduct();
    }

    @RequestMapping(value = "getTestA")
    public String getTestA(){

        return testService.getProductA();
    }

    @RequestMapping(value = "getTestB")
    public String getTestB(){
        String tempo = "";
        for(int i=0;i<50;i++){
            tempo += testService.getProductB(i) + "\n";
        }
        return tempo;
    }

    public String fallback(){
        return "error";
    }
}
