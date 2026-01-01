package com.userapp.service;

import com.userapp.core.AppServiceName;
import com.userapp.core.UserBaseService;
import com.userapp.core.UserPipelineRegistry;
import com.userapp.core.UserServiceMarker;
import com.userapp.model.context.UserContext;
import com.userapp.model.context.UserPageContext;
import com.userapp.model.entity.AppUser;
import com.userapp.model.enums.ServiceKeys;
import com.userapp.model.enums.UserPipeline;
import com.userapp.model.request.UserCreateRequest;
import com.userapp.respository.AppUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AppServiceName(ServiceKeys.USER_SERVICE)
public class UserService extends UserBaseService implements UserServiceMarker {
    private final AppUserRepository appUserRepository;

    public UserService(AppUserRepository appUserRepository,
                       UserPipelineRegistry registry) {
        this.appUserRepository = appUserRepository;
        this.registry = registry;
    }

    public UserContext save(UserCreateRequest request) {
        UserContext ctx = UserContext.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(request.getPassword())
                .status(request.getStatus())
                .build();
        return process(UserPipeline.USER_CREATE, ctx);
    }

    public UserContext update(UserCreateRequest request) {
        UserContext ctx = UserContext.builder()
                .id(request.getId())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(request.getPassword())
                .status(request.getStatus())
                .build();
        return process(UserPipeline.USER_UPDATE, ctx);
    }

    @Transactional(readOnly = true)
    public UserContext findById(Long id) {
        UserContext ctx = UserContext.builder()
                .id(id)
                .build();
        return process(UserPipeline.USER_FIND_BY_ID, ctx);
    }

    @Transactional(readOnly = true)
    public UserPageContext findAll(int page, int size) {
        UserPageContext ctx = UserPageContext.builder()
                .page(page)
                .size(size)
                .build();
        process(UserPipeline.USER_FIND_ALL, ctx);
        return ctx;
    }
}
