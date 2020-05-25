package com.example.jwtdemo.controllers;

import com.example.jwtdemo.models.BaseResp;
import com.example.jwtdemo.jwt.JWTUtils;
import com.example.jwtdemo.entity.User;
import com.example.jwtdemo.jwt.JwtTokenIgnore;
import com.example.jwtdemo.models.ErrorCode;
import com.example.jwtdemo.utils.BaseRespBody;
import com.example.jwtdemo.utils.RequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/login")
public class LoginController {

    @JwtTokenIgnore
    @GetMapping("/index")
    public BaseResp<?> login(@RequestParam("phone") String phone) {
        User user = new User();
        user.id = UUID.randomUUID().toString();
        user.phone = phone;
        user.token = JWTUtils.create(user.id);
        return BaseResp.success(user);
    }

    @GetMapping("/test")
    public BaseResp<?> test() {
        User user = new User();
        user.id = RequestUtils.getUserId();
        return BaseResp.success(user);
    }

    @JwtTokenIgnore
    @BaseRespBody
    @GetMapping("/get-user")
    public User getUser() {
        User user = new User();
        user.id = "fake-id";
        user.phone = "fake-phone";
        return user;
    }


}
