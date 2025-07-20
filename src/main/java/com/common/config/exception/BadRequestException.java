package com.common.config.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@EqualsAndHashCode(callSuper = true)
@Data
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    private String code;

    private Object[] args;

    public BadRequestException(String code) {
        super(code);
        this.code = code;
    }

    public BadRequestException(String code, Object ...args) {
        super(code);
        this.code = code;
        this.args = args;
    }

}
