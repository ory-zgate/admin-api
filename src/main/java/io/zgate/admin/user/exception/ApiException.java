package io.zgate.admin.user.exception;

public class ApiException extends RuntimeException {
    private final ErrorEnum errorEnum;

    public ApiException(ErrorEnum errorEnum) {
        this.errorEnum = errorEnum;
    }

    public ErrorEnum getErrorEnum() {
        return errorEnum;
    }
}
