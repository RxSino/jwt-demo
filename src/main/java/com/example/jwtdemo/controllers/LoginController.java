package com.example.jwtdemo.controllers;

import com.example.jwtdemo.models.BaseResp;
import com.example.jwtdemo.jwt.JWTUtils;
import com.example.jwtdemo.entity.User;
import com.example.jwtdemo.annotations.UnToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController("/login")
public class LoginController {

    @UnToken
    @GetMapping("/index")
    public BaseResp<?> login(@RequestParam("phone") String phone) {
        User user = new User();
        user.id = UUID.randomUUID().toString();
        user.phone = phone;
        user.token = JWTUtils.create(user.id);
        return BaseResp.success(user);
    }

    @GetMapping("/test")
    public BaseResp<?> test(@RequestParam("phone") String phone) {
        User user = new User();
        user.id = UUID.randomUUID().toString();
        user.phone = phone;
        user.token = JWTUtils.create(user.id);
        return BaseResp.success(user);
    }

}
