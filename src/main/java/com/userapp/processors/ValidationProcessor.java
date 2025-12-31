package com.userapp.processors;

import com.userapp.model.context.UserContext;
import com.userapp.respository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component("step.user.validate")
public class ValidationProcessor implements ProcessorStep<UserContext> {

    private final AppUserRepository repository;

    @Override
    public void execute(UserContext ctx) {
        if (!ctx.isSuccess()) return;
        if (ctx.getEmail() == null || ctx.getEmail().isBlank()) {
            ctx.fail("Email is required");
            return;
        }
        if (ctx.getId() == null && repository.existsByEmail(ctx.getEmail())) {
            ctx.fail("Email already exists");
        }
    }
}
