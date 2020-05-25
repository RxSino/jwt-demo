package com.example.jwtdemo.controllers;

import com.example.jwtdemo.models.BaseResp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// better ?
//@RestController
//@RequestMapping("/error")
public class ErrorController {

    @GetMapping("")
    public BaseResp<?> error() {
        return BaseResp.error();
    }

    @GetMapping("/404")
    public BaseResp<?> notFound() {
        return BaseResp.error();
    }

}
