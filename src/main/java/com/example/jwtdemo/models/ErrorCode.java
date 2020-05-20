package com.example.jwtdemo.models;

public enum ErrorCode {
    Success("0", "ok"),
    Unknown("-1", "unknown"),
    Token("-2", "Token错误");

    public String code;
    public String msg;

    ErrorCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
