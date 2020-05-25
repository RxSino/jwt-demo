package com.example.jwtdemo.jwt;

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
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        JwtTokenIgnore jwtTokenIgnore = method.getAnnotation(JwtTokenIgnore.class);
        if (null != jwtTokenIgnore) {
            return true;
        }

        String token = request.getHeader("Jwt-Token");
        if (token == null || token.equals("")) {
            throw new TokenException();
        }

        if (!JWTUtils.verify(token)) {
            throw new TokenException();
        }

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}
