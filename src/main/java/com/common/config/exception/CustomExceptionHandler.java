package com.common.config.exception;

import com.common.config.model.ResModel;
import com.common.config.model.SessionHelper;
import com.common.config.util.ResourceUtil;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Objects;

@RestControllerAdvice
public class CustomExceptionHandler {
    private final SessionHelper sessionHelper;

    public CustomExceptionHandler(SessionHelper sessionHelper) {
        this.sessionHelper = sessionHelper;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResModel<String> handleAllException(Exception ex, WebRequest webRequest) {
        return new ResModel<>(null, 500, "INTERNAL_SERVER_ERROR", ex.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResModel<String> handlerRequestException(NotFoundException ex) {
        return new ResModel<>(
                null,
                404,
                ex.getCode(),
                ResourceUtil.getMessage(sessionHelper.getLanguage(), ex.getCode(), ex.getArgs())
        );
    }

    @ExceptionHandler({
            BadRequestException.class
    })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResModel<?> handlerRequestException(BadRequestException ex) {
        return new ResModel<>(
                null,
                400,
                ex.getCode(),
                ResourceUtil.getMessage(sessionHelper.getLanguage(), ex.getCode(), ex.getArgs())
        );
    }

    @ExceptionHandler({
            AuthenticationException.class,
    })
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResModel<String> unauthorizedException(AuthenticationException ex) {
        return new ResModel<>(
                null,
                401,
                ex.getCode(),
                ResourceUtil.getMessage(sessionHelper.getLanguage(), ex.getCode())
        );
    }

    @ExceptionHandler({ForbiddenException.class})
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResModel<String> forbiddenException(ForbiddenException ex) {
        return new ResModel<>(
                null,
                403,
                ex.getCode(),
                ResourceUtil.getMessage(sessionHelper.getLanguage(), ex.getCode())
        );
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResModel<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        if (ex.getBindingResult().getAllErrors().isEmpty()) {
            return new ResModel<>(
                    null,
                    400,
                    "BAD_REQUEST",
                    ex.getMessage());
        }
        ObjectError error = ex.getBindingResult().getAllErrors().getFirst();
        String message = Objects.requireNonNull(error.getDefaultMessage());
        try {
            return new ResModel<>(
                    null,
                    400,
                    message,
                    ResourceUtil.getMessage(sessionHelper.getLanguage(), message)
            );
        } catch (Exception e) {
            return new ResModel<>(
                    null,
                    400,
                    "BAD_REQUEST",
                    message);
        }
    }
}