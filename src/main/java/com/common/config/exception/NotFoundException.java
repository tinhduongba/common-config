package com.common.config.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@EqualsAndHashCode(callSuper = true)
@ResponseStatus(HttpStatus.NOT_FOUND)
@Data
public class NotFoundException extends Exception {

    @Serial
    private static final long serialVersionUID = 1L;

    private String code;

    private Object[] args;

    public NotFoundException(String code) {
        super(code);
        this.code = code;
    }

    public NotFoundException(String code, Object ...args) {
        super(code);
        this.code = code;
        this.args = args;
    }
}
