package com.userapp.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserPipeline {
    USER_CREATE("pipeline.user.create"),
    USER_UPDATE("pipeline.user.update"),
    USER_FIND_BY_ID("pipeline.user.findById");

    private final String beanName;
}
