package com.common.config.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class ResModel<T> implements Serializable {

    private T data;

    private Boolean success = false;

    private BaseError error;

    public static <V> ResModel<V> ok(V data) {
        return new ResModel<>(data);
    }

    public static ResModel<String> ok() {
        return new ResModel<>("Successfully");
    }

    public ResModel() {
    }

    public ResModel(T oData) {
        this.data = oData;
        this.success = true;
    }

    public ResModel(Boolean success, T oData) {
        this.data = oData;
        this.success = success;
    }

    public ResModel(T oData, BaseError error) {
        this.success = false;
        this.data = oData;
        this.error = error;
    }

    public ResModel(Boolean success, T oData, String message, int code) {
        this.success = success;
        this.data = oData;
        this.error = new BaseError(code, String.valueOf(code), message);
    }

    public ResModel(T oData, int code, String codeString, String message) {
        this.data = oData;
        this.error = new BaseError(code, codeString, message);
    }

    public ResModel(T oData, int code) {
        this.data = oData;
        this.error = new BaseError(code, String.valueOf(code), "");
    }

    public ResModel(T oData, int code, String message) {
        this.data = oData;
        this.error = new BaseError(code, String.valueOf(code), message);
    }
}
