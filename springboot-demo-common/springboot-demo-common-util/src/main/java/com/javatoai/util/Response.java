package com.javatoai.util;

import java.io.Serializable;


public class Response<T> implements Serializable {
    private final int code;
    private final String message;
    private final T data;

    private Response(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // 成功
    public static <T> Response<T> success() {
        return new Response<>(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getMessage(), null);
    }

    public static <T> Response<T> success(T data) {
        return new Response<>(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getMessage(), data);
    }

    public static <T> Response<T> success(String message, T data) {
        return new Response<>(ResponseCodeEnum.SUCCESS.getCode(), message, data);
    }

    // 失败
    public static <T> Response<T> error() {
        return new Response<>(ResponseCodeEnum.ERROR.getCode(), ResponseCodeEnum.ERROR.getMessage(), null);
    }

    public static <T> Response<T> error(String message) {
        return new Response<>(ResponseCodeEnum.ERROR.getCode(), message, null);
    }

    public static <T> Response<T> error(int code, String message) {
        return new Response<>(code, message, null);
    }

    public static <T> Response<T> error(ResponseCodeEnum codeEnum) {
        return new Response<>(codeEnum.getCode(), codeEnum.getMessage(), null);
    }

    public static <T> Response<T> error(ResponseCodeEnum codeEnum, String message) {
        return new Response<>(codeEnum.getCode(), message, null);
    }

    public static <T> Response<T> error(ResponseCodeEnum codeEnum, T data) {
        return new Response<>(codeEnum.getCode(), codeEnum.getMessage(), data);
    }

    public static <T> Response<T> error(ResponseCodeEnum codeEnum, String message, T data) {
        return new Response<>(codeEnum.getCode(), message, data);
    }

    // Getters
    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
