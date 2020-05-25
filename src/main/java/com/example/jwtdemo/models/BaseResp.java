package com.example.jwtdemo.models;

public class BaseResp<T> {

    public T data;
    public String errorMessage;
    public String errorCode;
    public boolean success;

    public boolean isNull() {
        return data == null;
    }

    public BaseResp() {
    }

    public BaseResp(T data, boolean success) {
        this.data = data;
        this.success = success;
    }

    public BaseResp(String errorMessage, String errorCode) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public static <T> BaseResp<T> success(T t) {
        return new BaseResp<>(t, true);
    }

    public static <T> BaseResp<T> error() {
        return new BaseResp<>("系统错误", "-1");
    }

    public static <T> BaseResp<T> error(String code, String message) {
        return new BaseResp<>(message, code);
    }

}
