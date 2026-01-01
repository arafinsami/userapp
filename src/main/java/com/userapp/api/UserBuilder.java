package com.userapp.api;

import com.userapp.core.UserServiceLocator;
import com.userapp.model.context.UserContext;
import com.userapp.model.context.UserPageContext;
import com.userapp.model.enums.ServiceKeys;
import com.userapp.model.request.UserCreateRequest;
import com.userapp.service.UserService;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UserBuilder {
    private static UserServiceLocator locator;

    public UserBuilder(UserServiceLocator locator) {
        UserBuilder.locator = locator;
    }

    public static UserContext save(UserCreateRequest request) {
        UserService service = locator.get(
                ServiceKeys.USER_SERVICE.getCode(),
                UserService.class
        );
        return service.save(request);
    }

    public static UserContext update(UserCreateRequest request) {
        Objects.requireNonNull(request, "request");
        Objects.requireNonNull(request.getId(), "id");

        UserService service = locator.get(
                ServiceKeys.USER_SERVICE.getCode(),
                UserService.class
        );
        return service.update(request);
    }

    public static UserContext findById(Long id) {
        Objects.requireNonNull(id, "id");
        UserService service = locator.get(
                ServiceKeys.USER_SERVICE.getCode(),
                UserService.class
        );
        return service.findById(id);
    }

    public static UserPageContext findAll(int page, int size) {
        UserService service = locator.get(
                ServiceKeys.USER_SERVICE.getCode(),
                UserService.class
        );
        return service.findAll(page, size);
    }
}
