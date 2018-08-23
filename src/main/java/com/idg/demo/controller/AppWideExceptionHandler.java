package com.idg.demo.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author xiongchenyang
 * @version [1.0 , 2018/8/23]
 */
@ControllerAdvice
public class AppWideExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String errorHandler(){
        return "demo/error";
    }
}  
