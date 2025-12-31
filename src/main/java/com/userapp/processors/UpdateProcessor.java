package com.userapp.processors;

import com.userapp.model.context.UserContext;
import com.userapp.model.entity.AppUser;
import com.userapp.respository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component("step.user.update")
public class UpdateProcessor implements ProcessorStep<UserContext> {
    private final AppUserRepository repository;

    @Override
    public void execute(UserContext ctx) {
        if (!ctx.isSuccess()) return;
        AppUser user = AppUser.builder()
                .id(ctx.getId())
                .firstName(ctx.getFirstName())
                .lastName(ctx.getLastName())
                .email(ctx.getEmail())
                .password(ctx.getPassword())
                .status(ctx.getStatus())
                .build();
        AppUser saved = repository.save(user);
        ctx.setId(saved.getId());
    }
}
