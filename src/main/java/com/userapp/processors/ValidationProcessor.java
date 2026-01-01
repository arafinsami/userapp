package com.userapp.processors;

import com.userapp.model.context.UserContext;
import com.userapp.respository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@RequiredArgsConstructor
@Component("step.user.validate")
public class ValidationProcessor implements ProcessorStep<UserContext> {
    private final AppUserRepository repository;

    @Override
    public void execute(UserContext ctx) {
        if (!ctx.isSuccess()) return;
        if (isNull(ctx.getEmail()) || ctx.getEmail().isBlank()) {
            ctx.fail("Email is required");
            return;
        }
        if (isNull(ctx.getId()) && repository.existsByEmail(ctx.getEmail())) {
            ctx.fail("Email already exists");
        }
    }
}
