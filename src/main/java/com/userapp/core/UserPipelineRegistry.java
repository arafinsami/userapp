package com.userapp.core;

import com.userapp.model.enums.UserPipeline;
import com.userapp.processors.AppProcessors;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class UserPipelineRegistry {
    private final ApplicationContext context;

    public UserPipelineRegistry(ApplicationContext context) {
        this.context = context;
    }

    public AppProcessors get(UserPipeline pipeline) {
        return context.getBean(pipeline.getBeanName(), AppProcessors.class);
    }
}
