package com.userapp.functions;

import com.userapp.api.UserBuilder;
import com.userapp.core.UserServiceLocatorHolder;
import com.userapp.model.context.UserContext;
import com.userapp.model.context.UserPageContext;
import com.userapp.model.enums.ServiceKeys;
import com.userapp.model.request.UserCreateRequest;
import com.userapp.service.UserService;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

public interface UserFunctions {

    static UserContext create(UserCreateRequest request) {
        requireNonNull(request, "request");
        UserService service = UserServiceLocatorHolder.get(ServiceKeys.USER_SERVICE, UserService.class);
        return service.save(request);
    }

    static UserContext update(UserCreateRequest request) {
        Objects.requireNonNull(request, "request");
        Objects.requireNonNull(request.getId(), "id");
        return UserBuilder.update(request);
    }

    static UserContext findById(Long id) {
        Objects.requireNonNull(id, "id");
        return UserBuilder.findById(id);
    }

    static UserPageContext findAll(int page, int size) {
        return UserBuilder.findAll(page, size);
    }
}
