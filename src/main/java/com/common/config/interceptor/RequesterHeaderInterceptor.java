package com.common.config.interceptor;

import com.common.config.model.RequesterHeaders;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.util.Strings;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.UUID;

public record RequesterHeaderInterceptor(RequesterHeaders requesterHeaders) implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String userId = request.getHeader("userId");
        String language = request.getHeader("lang");
        if (userId != null) requesterHeaders.setUserId(UUID.fromString(userId));
        requesterHeaders.setLanguage(Strings.isBlank(language) ? "en" : language);
        return true;
    }
}
