package com.userapp.core;

import com.userapp.model.context.UserContext;
import com.userapp.model.enums.UserPipeline;
import com.userapp.processors.AppProcessors;

public abstract class UserBaseService {
    protected UserPipelineRegistry registry;

    protected UserContext process(UserPipeline pipeline, UserContext ctx) {
        AppProcessors processor = registry.get(pipeline);
        processor.execute(ctx);
        return ctx;
    }
}
