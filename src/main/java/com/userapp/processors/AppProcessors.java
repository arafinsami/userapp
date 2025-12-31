package com.userapp.processors;

import com.userapp.model.context.UserContext;

import java.util.List;

public class AppProcessors {
    private final List<ProcessorStep<UserContext>> steps;

    public AppProcessors(List<ProcessorStep<UserContext>> steps) {
        this.steps = steps;
    }

    public void execute(UserContext ctx) {
        for (ProcessorStep<UserContext> step : steps) {
            step.execute(ctx);
        }
    }
}
