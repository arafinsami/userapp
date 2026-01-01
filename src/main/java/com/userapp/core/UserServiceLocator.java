package com.userapp.core;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserServiceLocator {
    private final UserServiceRouter router;

    public <T extends UserServiceMarker> T get(String key, Class<T> type) {
        return router.get(key, type);
    }
}
