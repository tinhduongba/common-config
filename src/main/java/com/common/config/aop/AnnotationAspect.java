package com.common.config.aop;

import com.common.config.aop.annotation.AuthorizeRequest;
import com.common.config.enumclass.ERole;
import com.common.config.exception.AuthenticationException;
import com.common.config.exception.ForbiddenException;
import com.common.config.model.SessionHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class AnnotationAspect {
    private final SessionHelper sessionHelper;

    @Around("@annotation(authorizationRequest)")
    public Object checkAuthorizePermission(ProceedingJoinPoint joinPoint, AuthorizeRequest authorizationRequest) throws
            Throwable {
        if (sessionHelper.getCurrentUserID() != null && !sessionHelper.getCurrentUserID()
                .toString().equals("00000000-0000-0000-0000-000000000000")) {
            String[] roles = Arrays.stream(authorizationRequest.roles()).map(Enum::name).toArray(String[]::new);
            List<String> userRoles = Arrays.stream(sessionHelper.getRoles()).toList();
            if (roles.length == 0 || userRoles.contains(ERole.ADMIN.name())) {
                return joinPoint.proceed();
            }
            for (String role : roles) {
                if (userRoles.contains(role))
                    return joinPoint.proceed();
            }
            throw new ForbiddenException("No permission");
        }

        throw new AuthenticationException("Authenticate is requested!");
    }
}