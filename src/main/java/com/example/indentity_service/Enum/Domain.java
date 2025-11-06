package com.example.indentity_service.Enum;

import lombok.Getter;

@Getter
public enum Domain {
    DEFAULT("DEFAULT"),
    USER("USER"),
    PRODUCT("PRODUCT"),
    ORDER("ORDER");

    private final String code;

    Domain(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
