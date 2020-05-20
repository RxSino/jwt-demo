package com.example.jwtdemo.entity;


public class User {

    public String id;

    public String phone;

    public String token;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "token='" + token + '\'' +
                '}';
    }
}
