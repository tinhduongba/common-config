package com.common.config.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseError {
    private int code;

    private String codeString;

    private String message;

    public BaseError(){}

    public BaseError(int code, String codeString, String message) {
        this.code = code;
        this.codeString = codeString;
        this.message = message;
    }
}
