package com.common.config.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@EqualsAndHashCode(callSuper = true)
@ResponseStatus(HttpStatus.FORBIDDEN)
@Data
public class ForbiddenException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    private String code;

    public ForbiddenException(String code) {
        super(code);
        this.code = code;
    }
}
