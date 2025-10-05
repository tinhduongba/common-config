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
        String roles = request.getHeader("roles");
        String language = request.getHeader("lang");
        String companyId = request.getHeader("companyId");
        if (!Strings.isBlank(userId)) requesterHeaders.setUserId(UUID.fromString(userId));
        if (!Strings.isBlank(roles)) requesterHeaders.setRoles(roles.split(","));
        if (!Strings.isBlank(companyId)) requesterHeaders.setCompanyId(UUID.fromString(companyId));
        requesterHeaders.setLanguage(Strings.isBlank(language) ? "en" : language);
        return true;
    }
}
