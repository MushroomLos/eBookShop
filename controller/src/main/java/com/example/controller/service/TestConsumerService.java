package com.example.controller.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name = "product-server",path ="product" )
public interface TestConsumerService {
//    @Retry(name = "retryBackendA")//, fallbackMethod = "fallback")
    @CircuitBreaker(name = "backendA")//,fallbackMethod = "fallback")
    @RequestMapping(value = "test",method = RequestMethod.GET)
    String getProduct();

//    @Retry(name = "retryBackendA")//, fallbackMethod = "fallback")
    @CircuitBreaker(name = "backendA")//,fallbackMethod = "fallback")
    @RequestMapping(value = "testA",method = RequestMethod.GET)
    String getProductA();

//    @Retry(name = "retryBackendA", fallbackMethod = "fallback_num")
    @CircuitBreaker(name = "backendA",fallbackMethod = "fallback_num")
    @RequestMapping(value = "testB",method = RequestMethod.GET)
    String getProductB(int i);

    default String fallback(){
        return "error";
    }

    default String fallback_num(int i){
        return "error";
    }
}
