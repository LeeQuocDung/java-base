package com.example.indentity_service.Enum;

public enum ErrorCode {
    INTERNAL_SERVER_ERROR(500, "Đã xảy ra lỗi trong quá trình xử lý"),
    ;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
