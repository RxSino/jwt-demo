package com.example.jwtdemo.jwt;

import com.example.jwtdemo.annotations.UnToken;
import com.example.jwtdemo.exceptions.TokenException;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Component
public class JWTTokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        UnToken unToken = method.getAnnotation(UnToken.class);
        if (null != unToken) {
            return true;
        }

        String token = request.getHeader("Token");
        if (token == null || token.equals("")) {
            return false;
        }

        if (!JWTUtils.verify(token)) {
            throw new TokenException();
        }

        String uid = JWTUtils.getUid(token);
        request.setAttribute("uid", uid);
        return true;
    }

}
