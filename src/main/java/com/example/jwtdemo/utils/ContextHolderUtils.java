package com.example.jwtdemo.utils;

import com.example.jwtdemo.jwt.JWTUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class ContextHolderUtils {

    public static HttpServletRequest getRequest() {
        ServletRequestAttributes attributes = (ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes();
        return attributes == null ? null : attributes.getRequest();
    }

    public static String getUserId() {
        if (getRequest() != null) {
            String token = getRequest().getHeader("Jwt-Token");
            return JWTUtils.getUid(token);
        }
        return null;
    }

}
