package com.javatoai.clickhouse.util;

/**
 *
 */
public enum ResponseCodeEnum implements IBaseEnum {
    SUCCESS(200, "成功"),
    ERROR(500, "服务器错误"),
    NOT_FOUND(404, "资源未找到"),
    UNAUTHORIZED(401, "未授权"),
    FORBIDDEN(403, "禁止访问");

    private final int code;
    private final String message;

    ResponseCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
