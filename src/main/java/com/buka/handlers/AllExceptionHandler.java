package com.buka.handlers;

import com.buka.http.HttpCode;
import com.buka.util.ResponseJson;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice

public class AllExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseJson exceptionHandler(Exception e){
        e.printStackTrace();
        return ResponseJson.getInstance(HttpCode.SYSTEMERROR,null);
    }

}
