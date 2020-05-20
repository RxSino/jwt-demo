package com.example.jwtdemo.models;

public class Response {

    public String errorMessage;
    public String errorCode;
    public boolean success;

    public Response(boolean success) {
        this.success = success;
    }

    public Response(String errorMessage, String errorCode, boolean success) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.success = success;
    }

    public static Response success() {
        return new Response(true);
    }

    public static Response error() {
        return new Response("", "", false);
    }

    public static Response error(String code, String msg) {
        return new Response(msg, code, false);
    }

}
