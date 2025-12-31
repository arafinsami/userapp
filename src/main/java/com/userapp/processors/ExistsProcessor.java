package com.userapp.processors;

import com.userapp.model.context.UserContext;
import com.userapp.respository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component("step.user.exists")
public class ExistsProcessor implements ProcessorStep<UserContext> {
    private final AppUserRepository repository;

    @Override
    public void execute(UserContext ctx) {
        if (!ctx.isSuccess()) return;
        if (ctx.getId() == null || !repository.existsById(ctx.getId())) {
            ctx.fail("User not found");
        }
    }
}
