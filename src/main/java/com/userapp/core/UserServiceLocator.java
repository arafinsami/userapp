package com.userapp.core;

import org.springframework.stereotype.Component;

@Component
public class UserServiceLocator {
    private final UserServiceRouter router;

    public UserServiceLocator(UserServiceRouter router) {
        this.router = router;
    }

    public <T extends UserServiceMarker> T get(String key, Class<T> type) {
        return router.get(key, type);
    }
}
