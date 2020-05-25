package com.example.jwtdemo;

import com.example.jwtdemo.exceptions.ErrorException;
import com.example.jwtdemo.exceptions.TokenException;
import com.example.jwtdemo.models.BaseResp;
import com.example.jwtdemo.models.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(value = TokenException.class)
    @ResponseStatus(HttpStatus.OK)
    public BaseResp<?> tokenException(TokenException e) {
        return BaseResp.error(ErrorCode.Token.code, ErrorCode.Token.msg);
    }

    @ExceptionHandler(value = ErrorException.class)
    @ResponseStatus(HttpStatus.OK)
    public BaseResp<?> errorException(ErrorException e) {
        return BaseResp.error();
    }

}
