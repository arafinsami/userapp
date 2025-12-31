package com.userapp.processors;

import com.userapp.model.context.UserContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component("step.user.errorLogger")
public class ErrorLogProcessor implements ProcessorStep<UserContext> {
    @Override
    public void execute(UserContext ctx) {
        if (!ctx.isSuccess()) {
            log.error("[USER-ERROR] {}", ctx.getErrorMessage());
        }
    }
}
