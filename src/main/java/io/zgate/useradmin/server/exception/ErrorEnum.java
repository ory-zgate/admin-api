package io.zgate.useradmin.server.exception;

public enum ErrorEnum {
    IDENTITY_NOT_FOUND(1001, "identity not found");

    private final int code;
    private final String desc;

    ErrorEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
