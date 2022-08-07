package com.cb.coin.exception;

public enum ErrorCode {
    INTERNAL_ERROR("internal_server_error"),
    NOT_FOUND("not_found"),
    CONFLICT("conflict");
    private String code;

    ErrorCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
