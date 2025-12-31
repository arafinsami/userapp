package com.userapp.core;

import com.userapp.model.enums.ServiceKeys;
import org.springframework.stereotype.Component;

@Component
public class UserServiceLocatorHolder {

    private static UserServiceLocator locator;

    public UserServiceLocatorHolder(UserServiceLocator locator) {
        UserServiceLocatorHolder.locator = locator;
    }

    public static <T extends UserServiceMarker> T get(ServiceKeys key, Class<T> type) {
        if (locator == null) {
            throw new IllegalStateException("ServiceLocator not initialized");
        }
        return locator.get(key.getCode(), type);
    }
}

