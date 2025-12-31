package com.userapp.processors;

import com.userapp.model.context.UserContext;

public interface ProcessorStep<T extends UserContext> {
    void execute(T ctx);
}
