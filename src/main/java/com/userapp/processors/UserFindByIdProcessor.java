package com.userapp.processors;

import com.userapp.model.context.UserContext;
import com.userapp.model.entity.AppUser;
import com.userapp.respository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component("step.user.findById")
public class UserFindByIdProcessor implements ProcessorStep<UserContext> {
    private final AppUserRepository repository;

    @Override
    public void execute(UserContext ctx) {
        if (!ctx.isSuccess()) return;
        AppUser user = repository.findById(ctx.getId())
                .orElseGet(() -> {
                    ctx.fail("User not found");
                    return null;
                });
        if (!ctx.isSuccess()) return;
        ctx.setFirstName(user.getFirstName());
        ctx.setLastName(user.getLastName());
        ctx.setEmail(user.getEmail());
        ctx.setStatus(user.getStatus());
    }
}
