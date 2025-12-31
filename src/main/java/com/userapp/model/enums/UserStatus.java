package com.userapp.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserStatus {
    ACTIVE("ACTIVE", "User Status: ACTIVE"),
    INACTIVE("INACTIVE", "User Status: INACTIVE");
    private final String code;
    private final String description;
}
