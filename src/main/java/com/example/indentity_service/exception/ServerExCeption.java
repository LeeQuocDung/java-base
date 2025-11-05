package com.example.indentity_service.exception;

import com.example.indentity_service.Enum.ErrorCode;

public class ServerExCeption extends RuntimeException {
    private ErrorCode errorCode ;
    public ServerExCeption(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
