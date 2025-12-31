package com.userapp.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ServiceKeys {
    USER_SERVICE("USER_SERVICE", "Service Keys: ServiceKeys");
    public final String code;
    public final String description;
}
